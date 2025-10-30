package com.example.realtimeedgedetection;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class MainActivity extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2 {

    private JavaCameraView cameraView;
    private Mat inputFrame, processedFrame;

    static {
        System.loadLibrary("opencv_java4");
        System.loadLibrary("native-lib");
    }

    public native void processImage(long matAddrInput, long matAddrOutput);

    private final BaseLoaderCallback loaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            if (status == LoaderCallbackInterface.SUCCESS) {
                cameraView.enableView();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraView = findViewById(R.id.camera_view);
        cameraView.setVisibility(SurfaceView.VISIBLE);
        cameraView.setCvCameraViewListener(this);
    }

    @Override
    public void onCameraViewStarted(int width, int height) {
        inputFrame = new Mat();
        processedFrame = new Mat();
    }

    @Override
    public void onCameraViewStopped() {
        inputFrame.release();
        processedFrame.release();
    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame input) {
        inputFrame = input.rgba();
        processImage(inputFrame.getNativeObjAddr(), processedFrame.getNativeObjAddr());
        return processedFrame;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!OpenCVLoader.initDebug()) {
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION, this, loaderCallback);
        } else {
            loaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
    }
}

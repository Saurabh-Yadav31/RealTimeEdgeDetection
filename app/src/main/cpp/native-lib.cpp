#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_realtimeedgedetection_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Native build working successfully!";
    return env->NewStringUTF(hello.c_str());
}

# RealTimeEdgeDetection

An Android application that performs **real-time edge detection** using the **OpenCV** library and native C++ (NDK) integration.

---

## 📍 Current Progress

### ✅ Project Setup Completed
- Created a new Android Studio project named **RealTimeEdgeDetection**.
- Set up **C++ support** with a `cpp/` folder containing `native-lib.cpp` and `CMakeLists.txt`.
- Verified build environment with Gradle sync.

### ✅ OpenCV SDK Integration
- Added **OpenCV Android SDK** as a separate module (`:sdk`).
- Linked the OpenCV module with the app through Gradle configuration.
- Configured **CMake** to build native code with OpenCV libraries.

### ✅ UI and Layout Design
- Updated `activity_main.xml` to include `JavaCameraView` for displaying real-time camera feed.
- Prepared the interface for live edge detection visualization.

### ✅ Native and Java Linking
- Connected `MainActivity.java` with `native-lib.cpp` for C++ function calls.
- Ensured compatibility with OpenCV JNI interface for native image processing.

---

## ⚙️ Tools and Technologies

- **Android Studio** (latest version)
- **OpenCV Android SDK (v4.x)**
- **C++ / NDK**
- **CMake 3.22.1**
- **Gradle 8.x**
- **Java 11 Compatibility**

---

## 🚧 Next Steps

- Fix OpenCV Java import references (`BaseLoaderCallback`, `LoaderCallbackInterface`, etc.)
- Initialize and test OpenCV camera preview.
- Implement edge detection using Canny filter in native code.
- Optimize frame rendering for real-time performance.

---

**Developed by:** Saurabh Yadav  
**GitHub Repository:** [https://github.com/Saurabh-Yadav31/RealTimeEdgeDetection](https://github.com/Saurabh-Yadav31/RealTimeEdgeDetection)

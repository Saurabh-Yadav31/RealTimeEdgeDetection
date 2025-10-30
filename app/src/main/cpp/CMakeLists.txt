cmake_minimum_required(VERSION 3.4.1)

# Add your native source file
add_library(
        native-lib
        SHARED
        src/main/cpp/native-lib.cpp)

# Include OpenCV headers
include_directories(${CMAKE_SOURCE_DIR}/src/main/cpp/include)

# Import the OpenCV shared library
add_library(opencv_java4 SHARED IMPORTED)
set_target_properties(opencv_java4 PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_java4.so)

# Find Android log library
find_library(log-lib log)

# Link all libraries
target_link_libraries(
        native-lib
        opencv_java4
        ${log-lib})

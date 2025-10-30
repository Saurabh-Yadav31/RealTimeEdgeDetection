plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.realtimeedgedetection"
    compileSdk = 34  // keep or use 34/35/36 if available

    defaultConfig {
        applicationId = "com.example.realtimeedgedetection"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    sourceSets {
        getByName("main") {
            jniLibs.srcDirs("src/main/jniLibs")
        }
    }

    buildFeatures {
        viewBinding = true
    }

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
        }
    }
}


dependencies {
    // ✅ Link OpenCV module (change :sdk if your module name is different)
    implementation(project(":sdk"))

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

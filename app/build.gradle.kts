// build.gradle.kts (Module: app)

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.scoreapp" // Ganti dengan namespace proyek Anda
    compileSdk = 34 // Versi SDK yang Anda gunakan

    defaultConfig {
        applicationId = "com.example.scoreapp" // Ganti dengan ID aplikasi Anda
        minSdk = 24 // Versi minimum yang didukung
        targetSdk = 34 // Versi target
        versionCode = 1 // Kode versi aplikasi
        versionName = "1.0" // Nama versi aplikasi

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false // Menonaktifkan ProGuard untuk build release
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8 // Menggunakan Java 8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8" // Menentukan versi JVM
    }

    buildFeatures {
        dataBinding = true // Mengaktifkan Data Binding
    }
}

dependencies {
    implementation(libs.androidx.core.ktx) // KTX library untuk AndroidX Core
    implementation(libs.androidx.appcompat) // Library untuk AppCompat
    implementation(libs.material) // Material Design Components
    implementation(libs.androidx.activity) // Library untuk Activity
    implementation(libs.androidx.constraintlayout) // ConstraintLayout library

    // Dependensi untuk ViewModel dan LiveData
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1") // Versi terkini untuk ViewModel
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1") // Versi terkini untuk LiveData

    // Dependensi untuk Data Binding
    implementation("androidx.databinding:databinding-runtime:7.0.0") // Versi terkini untuk Data Binding

    // Dependensi untuk testing
    testImplementation(libs.junit) // Library untuk pengujian unit
    androidTestImplementation(libs.androidx.junit) // Library untuk pengujian AndroidX
    androidTestImplementation(libs.androidx.espresso.core) // Library untuk pengujian UI
}

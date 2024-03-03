plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

}

android {
    namespace = "com.example.solutionx"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.solutionx"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    flavorDimensions += "logging"
    productFlavors { // Braces are still used for the productFlavors block
        create("logCat") { // Use the create method instead of directly specifying flavor names
            dimension = "logging" // Use '=' instead of ':'
            // Customize as needed for logCat flavor
        }
        create("logWriter") {
            dimension = "logging"
            // Customize as needed for logWriter flavor
        }
        create("production") {
            dimension = "logging"
            // Customize as needed for production flavor
        }
    }

    buildFeatures{
        buildConfig =true
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
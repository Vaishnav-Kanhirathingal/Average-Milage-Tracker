plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("com.google.devtools.ksp")
    kotlin("plugin.serialization") version "2.2.0"
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.avarmil"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.avarmil"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

secrets {
    propertiesFileName = "secrets.properties"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    //------------------------------------------------------------------------------------------maps
    implementation(libs.play.services.maps)
    implementation(libs.maps.compose)
    implementation(libs.play.services.location)
    //------------------------------------------------------------------------------------navigation
    implementation(libs.androidx.navigation.compose)
    //---------------------------------------------------------------------------------serialization
    implementation(libs.kotlinx.serialization.json)
    //------------------------------------------------------------------------------------------room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    //-----------------------------------------------------------------------------------dagger-hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    //-----------------------------------------------------------------------------------permissions
    implementation("com.google.accompanist:accompanist-permissions:0.37.3")
}
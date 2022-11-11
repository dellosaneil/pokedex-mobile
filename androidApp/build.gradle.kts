import Build_gradle.Versions.composeActivityVersion
import Build_gradle.Versions.composeVersion

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.dellosaneil.pokedex_mobile.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.dellosaneil.pokedex_mobile.android"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {

    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.activity:activity-compose:$composeActivityVersion")
}

object Versions {
    const val composeVersion = "1.3.1"
    const val composeActivityVersion = "1.6.1"
}



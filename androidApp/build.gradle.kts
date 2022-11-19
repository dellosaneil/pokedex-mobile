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
        kotlinCompilerExtensionVersion = Versions.Project.composeCompiler
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

    // Compose
    implementation("androidx.compose.ui:ui:${Versions.Android.composeVersion}")
    implementation("androidx.compose.ui:ui-tooling:${Versions.Android.composeVersion}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Versions.Android.composeVersion}")
    implementation("androidx.compose.foundation:foundation:${Versions.Android.composeVersion}")
    implementation("androidx.compose.material:material:${Versions.Android.composeVersion}")
    implementation("androidx.activity:activity-compose:${Versions.Android.composeActivityVersion}")

    // Koin - DI
    implementation("io.insert-koin:koin-core:${Versions.Shared.koinVersion}")
    implementation("io.insert-koin:koin-android:${Versions.Android.koinVersion}")

    // Accompanist
    implementation("com.github.skydoves:landscapist-glide:${Versions.Android.glideVersion}")

    // Timber
    implementation ("com.jakewharton.timber:timber:${Versions.Android.timberVersion}")

}

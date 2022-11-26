plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.devtools.ksp") version Versions.Android.googleKspVersion
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

    applicationVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/$name/kotlin")
            }
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
    implementation("io.insert-koin:koin-androidx-compose:${Versions.Android.koinVersion}")

    // Coil
    implementation("io.coil-kt:coil-svg:${Versions.Android.coilSvgExtensionVersion}")
    implementation("io.coil-kt:coil-compose:${Versions.Android.coilComposeVersion}")
    implementation("io.coil-kt:coil-gif:${Versions.Android.coilGifExtensionVersion}")

    // Timber
    implementation("com.jakewharton.timber:timber:${Versions.Android.timberVersion}")

    // Navigation
    implementation("io.github.raamcosta.compose-destinations:animations-core:${Versions.Android.navigationVersion}")
    ksp("io.github.raamcosta.compose-destinations:ksp:${Versions.Android.navigationVersion}")

    // Accompanist
    implementation("com.google.accompanist:accompanist-pager:${Versions.Android.accompanistPagerVersion}")
    implementation("com.google.accompanist:accompanist-pager-indicators:${Versions.Android.accompanistPagerVersion}")

}

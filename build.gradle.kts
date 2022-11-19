plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("7.3.1").apply(false)
    id("com.android.library").version("7.3.1").apply(false)
    kotlin("android").version(Versions.Project.kotlinVersion).apply(false)
    kotlin("multiplatform").version(Versions.Project.kotlinVersion).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

allprojects {
    configurations {
        all {
            resolutionStrategy {
                force("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Shared.coroutineNativeVersion}-native-mt")
            }
        }
    }
}

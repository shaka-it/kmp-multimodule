plugins {
    alias(libs.plugins.moduleSetup)
}

android {
    namespace = "kmp.multimodule.project.common.core.presentation"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(libs.bundles.decompose.presentation)
                api(libs.koin.di)
                api(libs.coroutines.core)
            }
        }
    }
}
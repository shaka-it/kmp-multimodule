plugins {
    alias(libs.plugins.moduleSetup)
}

android {
    namespace = "kmp.multimodule.project.common.core.utils"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.koin.di)
            api(libs.bundles.navigation)
        }
    }
}
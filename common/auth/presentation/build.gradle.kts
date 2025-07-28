plugins {
    alias(libs.plugins.moduleSetup)
    alias(libs.plugins.serialization)
}

android {
    namespace = "kmp.multimodule.project.common.auth.presentation"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.common.core)
        }
    }
}
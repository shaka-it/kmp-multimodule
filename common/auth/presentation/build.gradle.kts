plugins {
    alias(libs.plugins.moduleSetup)
}

android {
    namespace = "kmp.multimodule.project.common.auth.presentation"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.common.corePresentation)
        }
    }
}
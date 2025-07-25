plugins {
    alias(libs.plugins.moduleSetup)
    alias(libs.plugins.composeSetup)
}

android {
    namespace ="kmp.multimodule.project.common.root"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(projects.common.root.presentation)
                api(projects.common.main.compose)
                api(projects.common.auth.compose)
                implementation(projects.common.coreCompose)
            }
        }
    }
}
plugins {
    alias(libs.plugins.moduleSetup)
    alias(libs.plugins.composeSetup)
}

android {
    namespace = "kmp.multimodule.project.common.auth.compose"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(projects.common.auth.presentation)
                implementation(projects.common.coreCompose)
            }
        }
    }
}
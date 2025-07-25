plugins {
    alias(libs.plugins.moduleSetup)
    alias(libs.plugins.composeSetup)
}

android {
    namespace = "kmp.multimodule.project.common.main.compose"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(projects.common.main.presentation)
                implementation(projects.common.coreCompose)
            }
        }
    }
}
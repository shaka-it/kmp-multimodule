plugins {
    alias(libs.plugins.moduleSetup)
    alias(libs.plugins.serialization)
}

android {
    namespace ="kmp.multimodule.project.common.root.presentation"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.core)
                implementation(projects.common.auth.presentation)
                implementation(projects.common.main.presentation)
            }
        }
    }
}
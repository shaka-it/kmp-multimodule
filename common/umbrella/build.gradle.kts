plugins {
    alias(libs.plugins.moduleSetup)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.core)
                implementation(projects.common.auth.impl)
                implementation(projects.common.pets.impl)
            }
        }
    }
}

android {
    namespace ="kmp.multimodule.project.common.umbrella"
}
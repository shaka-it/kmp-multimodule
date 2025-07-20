plugins {
    alias(libs.plugins.moduleSetup)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.core)
                implementation(projects.common.auth.data)
                implementation(projects.common.todos.data)
            }
        }
    }
}

android {
    namespace ="kmp.multimodule.project.common.umbrella"
}
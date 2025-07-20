plugins {
    alias(libs.plugins.moduleSetup)
}

android {
    namespace = "kmp.multimodule.project.common.todos.data"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.common.todos.api)
            implementation(projects.common.core)
        }
    }
}
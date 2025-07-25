plugins {
    alias(libs.plugins.moduleSetup)
}

android {
    namespace = "kmp.multimodule.project.common.posts.data"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.common.posts.api)
            implementation(projects.common.core)
        }
    }
}
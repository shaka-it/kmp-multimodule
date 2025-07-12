plugins {
    `kotlin-dsl`
}

group = "kmp.multimodule.project"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.plugin.android)
    compileOnly(libs.plugin.kotlin)
    compileOnly(libs.plugin.compose)
    compileOnly(libs.plugin.serialization)
    compileOnly(libs.plugin.sqldelight)
    compileOnly(libs.plugin.libres)
}

gradlePlugin {
    plugins {
        create("multiplatformSetup") {
            id = "multiplatform.setup"
            implementationClass = "kmp.multimodule.project.MultiplatformSetupPlugin"
        }
    }
}
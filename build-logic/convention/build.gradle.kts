plugins {
    `kotlin-dsl`
}

group = "kmp.multimodule.project.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.plugin.android)
    compileOnly(libs.plugin.kotlin)
    compileOnly(libs.plugin.compose)
    compileOnly(libs.plugin.serialization)
//    compileOnly(libs.plugin.sqldelight)
//    compileOnly(libs.plugin.libres)
}

gradlePlugin {
    plugins {
        create("moduleSetup") {
            id = "module.setup"
            implementationClass = "kmp.multimodule.project.plugins.ModuleSetupPlugin"
        }
        create("composeSetup") {
            id = "compose.setup"
            implementationClass = "kmp.multimodule.project.plugins.ComposeSetupPlugin"
        }
    }
}
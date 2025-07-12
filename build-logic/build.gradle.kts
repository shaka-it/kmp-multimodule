plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.plugin.android)
    implementation(libs.plugin.kotlin)
    implementation(libs.plugin.compose)
    implementation(libs.plugin.serialization)
    implementation(libs.plugin.sqldelight)
    implementation(libs.plugin.libres)
}

kotlin {
    sourceSets.getByName("main").kotlin.srcDir("build-logic/src/main/kotlin")
}
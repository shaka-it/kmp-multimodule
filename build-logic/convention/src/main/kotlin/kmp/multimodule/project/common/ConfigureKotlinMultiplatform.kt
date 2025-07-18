package kmp.multimodule.project.common

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureKotlinMultiplatform(
    extension: KotlinMultiplatformExtension,
) = extension.apply {
    js {
        browser()
    }

    jvm("desktop")

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    androidTarget()

    jvmToolchain(17)
}
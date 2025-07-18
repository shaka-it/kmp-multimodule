package kmp.multimodule.project.plugins

import com.android.build.gradle.LibraryExtension
import kmp.multimodule.project.common.configureAndroid
import kmp.multimodule.project.common.configureKotlinMultiplatform
import kmp.multimodule.project.common.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ModuleSetupPlugin : Plugin<Project> {
    override fun apply(project: Project) = project.run {
        with(pluginManager) {
            apply(libs.findPlugin("androidLibrary").get().get().pluginId)
            apply(libs.findPlugin("kotlinMultiplatform").get().get().pluginId)
        }

        extensions.configure<KotlinMultiplatformExtension>(::configureKotlinMultiplatform)
        extensions.configure<LibraryExtension>(::configureAndroid)
    }
}
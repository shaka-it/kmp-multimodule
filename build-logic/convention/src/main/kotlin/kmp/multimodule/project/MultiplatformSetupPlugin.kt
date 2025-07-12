package kmp.multimodule.project

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class MultiplatformSetupPlugin : Plugin<Project> {
    override fun apply(project: Project) = project.run {
        with(pluginManager) {
            apply("com.android.library")
            apply("org.jetbrains.compose")
            apply("org.jetbrains.kotlin.multiplatform")
        }

        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

        extensions.configure<KotlinMultiplatformExtension>("kotlin") {
            js {
                browser()
            }

            jvm("desktop")

            iosX64()
            iosArm64()
            iosSimulatorArm64()

            androidTarget()

            jvmToolchain(17)

            configure<SourceSetContainer> {
                named("commonMain") {
                    dependencies {
                        val compose =
                            extensions.getByName("compose") as org.jetbrains.compose.ComposePlugin.Dependencies
                        add("implementation", compose.foundation)
                        add("implementation", compose.material)
                    }
                }
            }
        }

        extensions.configure<LibraryExtension>("android") {
            compileSdk = libs.findVersion("android.compileSdk").get().toString().toInt()
        }
    }
}
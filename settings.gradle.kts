rootProject.name = "kmp-multimodule-project"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")

    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
    includeBuild("build-logic")
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

include(":composeApp")
include(":common:auth:api")
include(":common:auth:data")
include(":common:auth:compose")
include(":common:auth:presentation")
include(":common:todos:api")
include(":common:todos:data")
include(":common:todos:compose")
include(":common:todos:presentation")
include(":common:main:api")
include(":common:main:data")
include(":common:main:compose")
include(":common:main:presentation")
include(":common:core")
include(":common:umbrella")
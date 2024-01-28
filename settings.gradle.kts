@file:Suppress("UnstableApiUsage")

include(":modules:feature-photo-detail-impl")


include(":modules:feature-photo-detail-api")


enableFeaturePreview("STABLE_CONFIGURATION_CACHE")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")

    repositories {
        google()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

rootProject.name = "PhotoPicker"
include(":app")
include(":modules:feature-photos-list-api")
include(":modules:feature-photos-list-impl")

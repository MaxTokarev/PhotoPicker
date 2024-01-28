@file:Suppress("UnstableApiUsage")

plugins {
    id("convention.android.library")
    id("convention.android.hilt")
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ktorfit)
    alias(libs.plugins.sql.delight)
}

android {
    namespace = "com.android.photo.picker"
    buildFeatures.viewBinding = true
}

sqldelight {
    databases {
        create("PhotosDatabase") {
            packageName.set("com.android.photo.picker")
        }
    }
}

dependencies {
    api(project(":modules:feature-photos-list-api"))
    implementation(libs.constraint)
    implementation(libs.material)
    implementation(libs.ktx.fragment)
    implementation(libs.view.binding.delegate)
    implementation(libs.cicerone)
    implementation(libs.glide)

    implementation(libs.orbit.core)
    implementation(libs.orbit.viewmodel)

    implementation(libs.sql.delight)
    implementation(libs.sql.delight.coroutines)

    implementation(libs.ktor.serialization)
    implementation(libs.ktor.negotiation)
    implementation(libs.ktorfit.lib)
    ksp(libs.ktorfit.ksp)
}

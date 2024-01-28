@file:Suppress("UnstableApiUsage")

plugins {
    id("convention.android.library")
    id("convention.android.hilt")
}

android {
    namespace = "com.android.photo.picker"
    buildFeatures.viewBinding = true
}

dependencies {
    api(project(":modules:feature-photos-list-api"))
    implementation(libs.constraint)
    implementation(libs.material)
    implementation(libs.ktx.fragment)
    implementation(libs.view.binding.delegate)
    implementation(libs.cicerone)
    implementation(libs.ktorfit)
    implementation(libs.glide)

    implementation(libs.orbit.core)
    implementation(libs.orbit.viewmodel)
}

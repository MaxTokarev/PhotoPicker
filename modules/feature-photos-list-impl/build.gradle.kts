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
    implementation(libs.constraint)
    implementation(libs.material)
    implementation(libs.ktx.fragment)
    implementation(libs.view.binding.delegate)
    implementation(libs.cicerone)

    implementation(libs.orbit.core)
    implementation(libs.orbit.viewmodel)
}

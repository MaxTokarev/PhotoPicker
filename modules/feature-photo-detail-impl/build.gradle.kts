@file:Suppress("UnstableApiUsage")

plugins {
    id("convention.android.library")
    id("convention.android.hilt")
}

android {
    namespace = "com.android.photo.detail"
    buildFeatures.viewBinding = true
}

dependencies {
    api(project(":modules:feature-photo-detail-api"))
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
}

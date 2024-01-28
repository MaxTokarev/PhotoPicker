plugins {
    id("convention.android.application")
    id("convention.android.hilt")
}

android {
    namespace = "com.android.photo.picker"
}

dependencies {
    implementation(project(":modules:feature-photos-list-impl"))

    implementation(libs.splashScreen)
    implementation(libs.appCompat)
    implementation(libs.cicerone)
    implementation(libs.material)
    implementation(libs.kotlin.coroutines)
    implementation(libs.timber)
}

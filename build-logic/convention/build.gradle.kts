plugins {
    `kotlin-dsl`
}

group = "com.android.photo.picker.buildlogic"

dependencies {
    implementation(libs.android.gradle)
    implementation(libs.detekt.gradle)
    implementation(libs.hilt.gradle)
    implementation(libs.kotlin.gradle)
    implementation(libs.dependency.analysis.gradle)

    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        register("DetektPlugin") {
            id = "convention.detekt"
            implementationClass = "DetektPlugin"
        }
        register("ModuleDependencyAnalysisPlugin") {
            id = "convention.dependency.analysis"
            implementationClass = "ModuleDependencyAnalysisPlugin"
        }
        register("AndroidApplicationConventionPlugin") {
            id = "convention.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("AndroidLibraryConventionPlugin") {
            id = "convention.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("AndroidUiTestConventionPlugin") {
            id = "convention.android.ui.test"
            implementationClass = "AndroidUiTestConventionPlugin"
        }
        register("AndroidUnitTestConventionPlugin") {
            id = "convention.android.unit.test"
            implementationClass = "AndroidUnitTestConventionPlugin"
        }
        register("AndroidHiltConventionPlugin") {
            id = "convention.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
    }
}

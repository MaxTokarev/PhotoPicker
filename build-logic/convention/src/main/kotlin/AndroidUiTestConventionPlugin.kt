import com.android.build.gradle.BaseExtension
import com.android.photo.picker.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

@Suppress("Unused")
class AndroidUiTestConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            dependencies {
                "testImplementation"(libs.junit)
                "testImplementation"(libs.roboelectric)
                "testImplementation"(libs.kaspresso)
                "testImplementation"(libs.ktx.testing)
                "testImplementation"(libs.hilt.test)
                "kaptTest"(libs.hilt.test.compiler)
            }

            configure<BaseExtension> {
                testOptions {
                    // allow to run tests on JVM
                    unitTests.isReturnDefaultValues = true
                    unitTests.isIncludeAndroidResources = true
                }
            }
        }
    }
}

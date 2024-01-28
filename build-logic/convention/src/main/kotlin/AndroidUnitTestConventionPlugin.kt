import com.android.photo.picker.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

@Suppress("Unused")
class AndroidUnitTestConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            dependencies {
                "testImplementation"(libs.junit)
                "testImplementation"(libs.mockk)
                "testImplementation"(libs.kotlin.coroutines.test)
                "testImplementation"(kotlin("test"))
            }
        }
    }
}

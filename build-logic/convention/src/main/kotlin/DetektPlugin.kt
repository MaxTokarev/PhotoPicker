import com.android.photo.picker.ApkConfig
import com.android.photo.picker.libs
import io.gitlab.arturbosch.detekt.Detekt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType

@Suppress("Unused")
class DetektPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("io.gitlab.arturbosch.detekt")
            }

            tasks.withType<Detekt> {
                // Disable caching
                outputs.upToDateWhen { false }

                reports {
                    html.required.set(true)
                    xml.required.set(false)
                    txt.required.set(false)
                }

                setSource(files(projectDir))
                config.setFrom(files("$rootDir/config/detekt/detekt.yml"))

                include("**/*.kt", "**/*.kts")
                exclude(
                    "**/resources/**",
                    "**/build/**",
                )

                parallel = true

                buildUponDefaultConfig = true

                // Target version of the generated JVM bytecode. It is used for type resolution.
                jvmTarget = ApkConfig.JVM_TARGET.toString()
            }

            dependencies {
                "detektPlugins"(libs.detekt.ruleset.compiler)
                "detektPlugins"(libs.detekt.ruleset.ktlint)
                "detektPlugins"(libs.detekt.ruleset.twitter.compose)
            }
        }
    }
}

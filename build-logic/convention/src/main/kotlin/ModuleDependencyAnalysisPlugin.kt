import com.autonomousapps.DependencyAnalysisExtension
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware

@Suppress("Unused")
internal class ModuleDependencyAnalysisPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.autonomousapps.dependency-analysis")
            }
            dependencyAnalysis {
                issues {
                    all {
                        onModuleStructure { severity("warn") }
                        onUnusedDependencies {
                            severity("fail")
                            exclude("com.google.dagger:hilt-android", "() -> java.io.File?")
                        }
                        onUsedTransitiveDependencies { severity("ignore") }
                        onIncorrectConfiguration { severity("fail") }
                        onCompileOnly { severity("ignore") }
                        onRuntimeOnly { severity("ignore") }
                        onUnusedAnnotationProcessors {
                            severity("warn")
                            exclude("com.google.dagger:hilt-compiler")
                        }
                        onRedundantPlugins { severity("fail") }
                        ignoreKtx(true)
                    }
                }
            }
        }
    }

    private fun Project.dependencyAnalysis(configure: Action<DependencyAnalysisExtension>) {
        (this as ExtensionAware).extensions.configure("dependencyAnalysis", configure)
    }
}

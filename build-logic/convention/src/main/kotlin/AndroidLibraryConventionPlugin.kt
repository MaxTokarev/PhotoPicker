import com.android.build.gradle.LibraryExtension
import com.android.photo.picker.ApkConfig
import com.android.photo.picker.buildlogic.configureBuildTypes
import com.android.photo.picker.configureKotlinAndroid
import com.android.photo.picker.configureLint
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("Unused")
class AndroidLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                defaultConfig.targetSdk = ApkConfig.TARGET_SDK_VERSION

                configureKotlinAndroid(this)
                configureLint()
                configureBuildTypes()
            }
        }
    }
}

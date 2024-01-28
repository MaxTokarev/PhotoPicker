import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.BaseExtension
import com.android.photo.picker.ApkConfig
import com.android.photo.picker.buildlogic.configureBuildTypes
import com.android.photo.picker.configureKotlinAndroid
import com.android.photo.picker.configureLint
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("Unused")
internal class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig.targetSdk = ApkConfig.TARGET_SDK_VERSION

                configureKotlinAndroid(this)
                configureLint()
            }

            extensions.configure<BaseExtension> {
                configureBuildTypes()
            }
        }
    }
}

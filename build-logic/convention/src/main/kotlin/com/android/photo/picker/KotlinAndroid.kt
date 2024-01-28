package com.android.photo.picker

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Configure base Kotlin with Android options
 */
@Suppress("UnstableApiUsage")
internal fun Project.configureKotlinAndroid(commonExtension: CommonExtension<*, *, *, *>) {
    commonExtension.apply {
        compileSdk = ApkConfig.COMPILE_SDK_VERSION

        defaultConfig {
            minSdk = ApkConfig.MIN_SDK_VERSION

            packagingOptions {
                resources.excludes += "META-INF/*."
            }
        }

        compileOptions {
            sourceCompatibility = ApkConfig.JVM_TARGET
            targetCompatibility = ApkConfig.JVM_TARGET
        }

        tasks.withType<KotlinCompile>().configureEach {
            kotlinOptions {
                // Treat all Kotlin warnings as errors (disabled by default)
                // Override by setting warningsAsErrors=true in your ~/.gradle/gradle.properties
                val warningsAsErrors: String? by project
                allWarningsAsErrors = warningsAsErrors.toBoolean()

                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-opt-in=kotlin.RequiresOptIn",
                    // Enable experimental coroutines APIs, including Flow
                    "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                    "-opt-in=kotlinx.coroutines.FlowPreview",
                    "-opt-in=kotlin.time.ExperimentalTime",
                    "-Xcontext-receivers",
                )

                jvmTarget = ApkConfig.JVM_TARGET.toString()
            }
        }
    }
}

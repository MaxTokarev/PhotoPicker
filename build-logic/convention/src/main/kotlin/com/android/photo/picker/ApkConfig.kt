package com.android.photo.picker

import org.gradle.api.JavaVersion

object ApkConfig {
    const val MIN_SDK_VERSION = 26
    const val TARGET_SDK_VERSION = 34
    const val COMPILE_SDK_VERSION = 34

    val JVM_TARGET = JavaVersion.VERSION_17
}

package com.android.photo.picker.buildlogic

import com.android.build.gradle.BaseExtension

fun BaseExtension.configureBuildTypes() {
    buildTypes {
        maybeCreate("debug").apply {
            multiDexEnabled = true
            isDebuggable = true
        }
        maybeCreate("release").apply {
            isMinifyEnabled = true
            consumerProguardFile("proguard-rules.pro")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

package com.android.photo.picker

import com.android.build.api.dsl.CommonExtension

fun CommonExtension<*, *, *, *>.configureLint() {
    lint.abortOnError = true
    lint.warningsAsErrors = false
    lint.checkAllWarnings = true
    lint.htmlReport = true
    lint.checkDependencies = true
    lint.explainIssues = true
    lint.disable.add("InvalidPackage")
}

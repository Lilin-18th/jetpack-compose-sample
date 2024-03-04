import org.gradle.api.tasks.Delete

// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinGradlePlugin) apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}

buildscript {
    configurations.all {
        resolutionStrategy.eachDependency {
            when {
                requested.name == "javapoet" -> useVersion("1.13.0")
            }
        }
    }
}

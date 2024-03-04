package jp.com.template.project.app.primitive

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class AndroidComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            android {
                buildFeatures.compose = true
                composeOptions {
                    kotlinCompilerExtensionVersion = libs.version("composeCompiler")
                }
            }
            dependencies {
                implementation(platform(libs.library("compose-bom")))
                implementation(libs.library("core-ktx"))
                implementation(libs.library("compose-ui"))
                implementation(libs.library("compose-material3"))
                implementation(libs.library("compose-ui-tooling-preview"))
                implementation(libs.library("lifecycle-runtime-ktx"))
                implementation(libs.library("activity-compose"))
                testImplementation(libs.library("junit"))
                testImplementation(libs.library("androidx-test-ext-junit"))
                testImplementation(libs.library("espresso-core"))
                testImplementation(libs.library("compose-ui-test-junit4"))
                debugImplementation(libs.library("compose-ui-tooling"))
                debugImplementation(libs.library("compose-ui-test-manifest"))
            }
        }
    }
}

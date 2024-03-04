package jp.com.template.project.app.primitive

import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
            }

            androidLibrary {
                setupAndroid()
            }
        }
    }
}

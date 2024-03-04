import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "jp.com.template.project.app"

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

// If we use jvmToolchain, we need to install JDK 17
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "17"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.bundles.plugins)
    // https://github.com/google/dagger/issues/3068#issuecomment-1470534930
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "template.primitive.android.application.plugin"
            implementationClass = "jp.com.template.project.app.primitive.AndroidApplicationPlugin"
        }
        register("android") {
            id = "template.primitive.android.plugin"
            implementationClass = "jp.com.template.project.app.primitive.AndroidPlugin"
        }
        register("androidKotlin") {
            id = "template.primitive.android.kotlin.plugin"
            implementationClass = "jp.com.template.project.app.primitive.AndroidKotlinPlugin"
        }
        register("androidCompose") {
            id = "template.primitive.android.compose.plugin"
            implementationClass = "jp.com.template.project.app.primitive.AndroidComposePlugin"
        }
        // Conventions
        register("androidFeature") {
            id = "template.convention.android.feature"
            implementationClass = "jp.com.template.project.app.convention.AndroidFeaturePlugin"
        }
    }
}

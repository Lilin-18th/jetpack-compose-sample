plugins {
    id("template.convention.android.feature")
}

android.namespace = "jp.com.template.feature.main"

dependencies {
    implementation(libs.compose.hilt.navigation)
    implementation(libs.compose.material.icon)
    implementation(libs.compose.navigation)
}

plugins {
    id(ThunderbirdPlugins.App.androidCompose)
}

android {
    namespace = "app.k9mail.ui.catalog"

    defaultConfig {
        applicationId = "app.k9mail.ui.catalog"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(projects.core.ui.compose.designsystem)
    implementation(projects.core.ui.compose.designsystemBiometric)

    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.material.icons.extended)
}

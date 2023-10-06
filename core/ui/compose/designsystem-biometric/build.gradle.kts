plugins {
    id(ThunderbirdPlugins.Library.androidCompose)
}

android {
    namespace = "app.k9mail.core.ui.compose.designsystem.biometric"
    resourcePrefix = "designsystem_biometric_"
}

dependencies {
    api(projects.core.ui.compose.designsystem)
    implementation(libs.androidx.biometric)

    testImplementation(projects.core.ui.compose.testing)
}

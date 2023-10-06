package app.k9mail.ui.catalog

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentActivity
import app.k9mail.core.ui.compose.common.activity.setActivityContent
import app.k9mail.ui.catalog.ui.CatalogScreen

class CatalogActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setActivityContent {
            CatalogScreen()
        }
    }
}

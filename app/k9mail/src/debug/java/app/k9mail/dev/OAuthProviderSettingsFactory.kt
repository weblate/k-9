package app.k9mail.dev

import com.fsck.k9.BuildConfig
import com.fsck.k9.auth.OAuthProvider
import com.fsck.k9.auth.OAuthProviderSettings

class AppOAuthProviderSettings : OAuthProviderSettings {

    private val applicationId = BuildConfig.APPLICATION_ID
    override fun getClientId(provider: OAuthProvider): String {
        return when (provider) {
            OAuthProvider.AOL -> {
                "dj0yJmk9cHYydkJkTUxHcXlYJmQ9WVdrOWVHZHhVVXN4VVV3bWNHbzlNQT09JnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PTdm"
            }
            OAuthProvider.GOOGLE -> {
                "262622259280-5qb3vtj68d5dtudmaif4g9vd3cpar8r3.apps.googleusercontent.com"
            }
            OAuthProvider.MICROSOFT -> {
                "e647013a-ada4-4114-b419-e43d250f99c5"
            }
            OAuthProvider.YAHOO -> {
                "dj0yJmk9ejRCRU1ybmZjQlVBJmQ9WVdrOVVrZEViak4xYmxZbWNHbzlNQT09JnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PTZj"
            }
        }
    }

    override fun getRedirectUri(provider: OAuthProvider): String {
        return when (provider) {
            OAuthProvider.AOL -> {
                "$applicationId://oauth2redirect"
            }
            OAuthProvider.GOOGLE -> {
                "$applicationId:/oauth2redirect"
            }
            OAuthProvider.MICROSOFT -> {
                "msauth://com.fsck.k9.debug/VZF2DYuLYAu4TurFd6usQB2JPts%3D"
            }
            OAuthProvider.YAHOO -> {
                "$applicationId://oauth2redirect"
            }
        }
    }
}

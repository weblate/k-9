package com.fsck.k9.auth

interface OAuthProviderSettings {
    fun getClientId(provider: OAuthProvider): String

    fun getRedirectUri(provider: OAuthProvider): String
}

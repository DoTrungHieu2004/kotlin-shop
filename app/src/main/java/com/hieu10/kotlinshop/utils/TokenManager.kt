package com.hieu10.kotlinshop.utils

import android.content.Context
import androidx.core.content.edit

class TokenManager(context: Context) {
    private val prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);

    companion object {
        private const val TOKEN_KEY = "jwt_token"
        private const val USER_ROLE_KEY = "user_role"
    }

    fun saveToken(token: String) {
        prefs.edit { putString(TOKEN_KEY, token) }
    }

    fun getToken(): String? {
        return prefs.getString(TOKEN_KEY, null)
    }

    fun saveRole(role: String) {
        prefs.edit { putString(USER_ROLE_KEY, role) }
    }

    fun getRole(): String? {
        return prefs.getString(USER_ROLE_KEY, "USER")
    }

    fun clear() {
        prefs.edit { clear() }
    }
}
package com.hieu10.kotlinshop.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "auth_prefs")

class TokenManager(private val context: Context) {
    companion object {
        private val JWT_TOKEN_KEY = stringPreferencesKey("jwt_token")
    }

    // Get the token as a Flow for receive UI updates
    val tokenFlow: Flow<String?> = context.dataStore.data.map { prefs ->
        prefs[JWT_TOKEN_KEY]
    }

    // Save token after successful login/registration
    suspend fun saveToken(token: String) {
        context.dataStore.edit { prefs ->
            prefs[JWT_TOKEN_KEY] = token
        }
    }

    // Clear token on logout
    suspend fun deleteToken() {
        context.dataStore.edit { prefs ->
            prefs.remove(JWT_TOKEN_KEY)
        }
    }
}
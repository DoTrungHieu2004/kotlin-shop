package com.hieu10.kotlinshop.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TokenManager(private val context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth_prefs")

    companion object {
        private val JWT_TOKEN_KEY = stringPreferencesKey("jwt_token")
        private val REFRESH_TOKEN_KEY = stringPreferencesKey("refresh_token")
    }

    val tokenFlow: Flow<String?> = context.dataStore.data.map { it[JWT_TOKEN_KEY] }

    suspend fun saveTokens(token: String, refreshToken: String) {
        context.dataStore.edit { prefs ->
            prefs[JWT_TOKEN_KEY] = token
            prefs[REFRESH_TOKEN_KEY] = refreshToken
        }
    }

    suspend fun deleteTokens() {
        context.dataStore.edit { it.clear() }
    }
}
package com.hieu10.kotlinshop.di

import android.content.Context
import com.hieu10.kotlinshop.data.api.RetrofitClient
import com.hieu10.kotlinshop.utils.TokenManager
import retrofit2.Retrofit

class DefaultAppContainer(private val context: Context) : AppContainer {
    // Logic to save/load JWT tokens
    override val tokenManager: TokenManager by lazy {
        TokenManager(context)
    }

    // Single instance of Retrofit
    override val retrofit: Retrofit by lazy {
        RetrofitClient.create(tokenManager)
    }
}
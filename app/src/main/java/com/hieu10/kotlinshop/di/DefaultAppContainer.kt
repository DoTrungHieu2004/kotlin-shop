package com.hieu10.kotlinshop.di

import android.content.Context
import com.hieu10.kotlinshop.data.local.TokenManager
import com.hieu10.kotlinshop.data.remote.RetrofitClient
import com.hieu10.kotlinshop.data.remote.service.AuthAPIService
import com.hieu10.kotlinshop.data.repository.AuthRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class DefaultAppContainer(
    private val context: Context,
    private val tokenManager: TokenManager
) : AppContainer {
    private val tokenProvider: () -> String? = {
        runBlocking { tokenManager.tokenFlow.first() }
    }

    private val authAPIService: AuthAPIService by lazy {
        retrofit.create(AuthAPIService::class.java)
    }

    override val okHttpClient: OkHttpClient by lazy {
        RetrofitClient.createHttpClient(tokenProvider)
    }

    override val retrofit: Retrofit by lazy {
        RetrofitClient.createRetrofit(okHttpClient)
    }

    override val authRepository: AuthRepository by lazy {
        AuthRepository(authAPIService, tokenManager)
    }
}
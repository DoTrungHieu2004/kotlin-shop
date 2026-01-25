package com.hieu10.kotlinshop.di

import android.content.Context
import com.hieu10.kotlinshop.data.api.RetrofitClient
import com.hieu10.kotlinshop.data.local.TokenManager
import com.hieu10.kotlinshop.data.repository.AuthRepository
import com.hieu10.kotlinshop.data.repository.AuthRepositoryImpl

object ServiceLocator {
    private lateinit var applicationContext: Context

    fun init(context: Context) {
        applicationContext = context.applicationContext
    }

    private val tokenManager: TokenManager by lazy {
        TokenManager(applicationContext)
    }

    val authRepository: AuthRepository by lazy {
        AuthRepositoryImpl(RetrofitClient.authService, tokenManager)
    }
}
package com.hieu10.kotlinshop.di

import com.hieu10.kotlinshop.utils.TokenManager
import retrofit2.Retrofit

interface AppContainer {
    val tokenManager: TokenManager
    val retrofit: Retrofit
}
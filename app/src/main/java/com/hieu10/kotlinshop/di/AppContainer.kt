package com.hieu10.kotlinshop.di

import okhttp3.OkHttpClient
import retrofit2.Retrofit

interface AppContainer {
    val okHttpClient: OkHttpClient
    val retrofit: Retrofit
}
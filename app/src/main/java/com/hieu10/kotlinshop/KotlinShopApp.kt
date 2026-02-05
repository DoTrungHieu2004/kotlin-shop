package com.hieu10.kotlinshop

import android.app.Application
import com.hieu10.kotlinshop.data.local.TokenManager
import com.hieu10.kotlinshop.di.AppContainer
import com.hieu10.kotlinshop.di.DefaultAppContainer

class KotlinShopApp : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        val tokenManager = TokenManager(applicationContext)
        container = DefaultAppContainer(applicationContext, tokenManager)
    }
}
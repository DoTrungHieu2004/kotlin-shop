package com.hieu10.kotlinshop.data.api

import com.hieu10.kotlinshop.utils.TokenManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val tokenManager: TokenManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()

        // Retrieve token from the manager
        val token = tokenManager.getToken()

        if (token != null) {
            request.addHeader("Authorization", "Bearer $token")
        }

        return chain.proceed(request.build())
    }
}
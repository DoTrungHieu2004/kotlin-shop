package com.hieu10.kotlinshop.data.repository

import com.hieu10.kotlinshop.data.local.TokenManager
import com.hieu10.kotlinshop.data.model.User
import com.hieu10.kotlinshop.data.model.auth.LoginRequest
import com.hieu10.kotlinshop.data.model.auth.RegisterRequest
import com.hieu10.kotlinshop.data.remote.service.AuthAPIService

class AuthRepository(
    private val apiService: AuthAPIService,
    private val tokenManager: TokenManager
) {
    suspend fun login(request: LoginRequest): Result<User> {
        return try {
            val response = apiService.login(request)
            tokenManager.saveToken(response.token)
            Result.success(response.user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun register(request: RegisterRequest): Result<User> {
        return try {
            val response = apiService.register(request)
            tokenManager.saveToken(response.token)
            Result.success(response.user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getProfile(): Result<User> {
        return try {
            val user = apiService.getProfile()
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun logout() {
        tokenManager.deleteToken()
    }
}
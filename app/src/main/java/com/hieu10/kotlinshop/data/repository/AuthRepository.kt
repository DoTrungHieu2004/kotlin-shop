package com.hieu10.kotlinshop.data.repository

import com.hieu10.kotlinshop.data.api.service.AuthAPIService
import com.hieu10.kotlinshop.data.local.TokenManager
import com.hieu10.kotlinshop.data.model.User
import com.hieu10.kotlinshop.data.model.request.LoginRequest
import com.hieu10.kotlinshop.data.model.request.RegisterRequest
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(email: String, passwordHash: String): Result<User>
    suspend fun register(request: RegisterRequest): Result<User>
    suspend fun logout()
    val userToken: Flow<String?>
}

class AuthRepositoryImpl(
    private val apiService: AuthAPIService,
    private val tokenManager: TokenManager
) : AuthRepository {
    override val userToken: Flow<String?> = tokenManager.tokenFlow

    override suspend fun login(email: String, passwordHash: String): Result<User> {
        return try {
            val response = apiService.login(LoginRequest(email, passwordHash))
            if (response.isSuccessful) {
                val body = response.body()!!
                tokenManager.saveTokens(body.token, body.refreshToken)
                Result.success(body.user)
            } else {
                Result.failure(Exception("Login failed: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun register(request: RegisterRequest): Result<User> {
        return try {
            val response = apiService.register(request)
            if (response.isSuccessful && response.body() != null) {
                val body = response.body()!!
                tokenManager.saveTokens(body.token, body.refreshToken)
                Result.success(body.user)
            } else {
                Result.failure(Exception("Registration failed"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun logout() {
        tokenManager.deleteTokens()
    }
}
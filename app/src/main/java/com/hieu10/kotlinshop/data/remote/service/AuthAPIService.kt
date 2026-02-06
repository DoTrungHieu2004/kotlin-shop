package com.hieu10.kotlinshop.data.remote.service

import com.hieu10.kotlinshop.data.model.User
import com.hieu10.kotlinshop.data.model.auth.AuthResponse
import com.hieu10.kotlinshop.data.model.auth.LoginRequest
import com.hieu10.kotlinshop.data.model.auth.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface AuthAPIService {
    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest): AuthResponse

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): AuthResponse

    @GET("auth/profile")
    suspend fun getProfile(): User

    @PATCH("auth/profile")
    suspend fun updateProfile(@Body profileUpdate: Map<String, String>): User

    @PATCH("auth/password")
    suspend fun changePassword(@Body passwords: Map<String, String>): SimpleResponse
}

data class SimpleResponse(val message: String)
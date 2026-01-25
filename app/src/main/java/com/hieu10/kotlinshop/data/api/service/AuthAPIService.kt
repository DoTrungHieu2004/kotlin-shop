package com.hieu10.kotlinshop.data.api.service

import com.hieu10.kotlinshop.data.model.User
import com.hieu10.kotlinshop.data.model.request.LoginRequest
import com.hieu10.kotlinshop.data.model.request.RegisterRequest
import com.hieu10.kotlinshop.data.model.response.AuthResponse
import com.hieu10.kotlinshop.data.model.response.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface AuthAPIService {
    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<AuthResponse>

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>

    @GET("auth/profile")
    suspend fun getProfile(@Header("Authorization") token: String): Response<User>

    @PUT("auth/profile")
    suspend fun updateProfile(@Body profile: User): Response<User>

    @POST("auth/refresh")
    suspend fun refreshToken(@Body refreshToken: String): Response<TokenResponse>
}
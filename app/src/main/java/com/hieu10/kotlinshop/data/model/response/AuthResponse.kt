package com.hieu10.kotlinshop.data.model.response

import com.hieu10.kotlinshop.data.model.User

data class AuthResponse(
    val token: String,
    val refreshToken: String,
    val user: User
)
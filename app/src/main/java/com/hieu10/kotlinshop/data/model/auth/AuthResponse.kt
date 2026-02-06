package com.hieu10.kotlinshop.data.model.auth

import com.hieu10.kotlinshop.data.model.User

data class AuthResponse(
    val token: String,
    val user: User
)
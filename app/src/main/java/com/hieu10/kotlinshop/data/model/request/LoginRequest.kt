package com.hieu10.kotlinshop.data.model.request

data class LoginRequest(
    val email: String,
    val password_hash: String
)
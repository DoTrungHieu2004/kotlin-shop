package com.hieu10.kotlinshop.data.model.auth

data class LoginRequest(
    val email: String,
    val password_hash: String
)
package com.hieu10.kotlinshop.data.model.auth

data class RegisterRequest(
    val username: String,
    val email: String,
    val password_hash: String,
    val phone: String? = null
)
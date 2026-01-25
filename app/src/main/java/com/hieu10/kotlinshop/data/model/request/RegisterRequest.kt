package com.hieu10.kotlinshop.data.model.request

data class RegisterRequest(
    val username: String,
    val email: String,
    val password_hash: String,
    val phone: String? = null
)
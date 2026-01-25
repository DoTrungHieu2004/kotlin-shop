package com.hieu10.kotlinshop.data.model

data class User(
    val id: String,
    val username: String,
    val email: String,
    val phone: String,
    val role: String,   // admin, moderator, user
    val avatarUrl: String?,
    val credits: Double // ¤ Currency
)
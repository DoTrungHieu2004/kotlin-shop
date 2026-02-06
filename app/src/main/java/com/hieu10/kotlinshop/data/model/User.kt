package com.hieu10.kotlinshop.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("_id") val id: String,
    val username: String,
    val email: String,
    val phone: String?,
    val role: UserRole,
    val status: String,
    @SerializedName("avatar_url") val avatarUrl: String?,
    val addresses: List<Address> = emptyList(),
    val preferences: UserPreferences,
    @SerializedName("last_login_at") val lastLoginAt: String?,
    @SerializedName("created_at") val createdAt: String
)

enum class UserRole {
    @SerializedName("user") USER,
    @SerializedName("moderator") MODERATOR,
    @SerializedName("admin") ADMIN
}

data class UserPreferences(
    val personalization: Boolean = true,
    val language: String = "en"
)
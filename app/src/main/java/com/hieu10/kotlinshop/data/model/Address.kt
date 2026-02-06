package com.hieu10.kotlinshop.data.model

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("_id") val id: String? = null,
    @SerializedName("user_id") val userId: String,
    val type: String,   // e.g., "Home", "Office"
    val street: String,
    val city: String,
    val state: String,
    @SerializedName("zip_code") val zipCode: String,
    @SerializedName("is_default") val isDefault: Boolean = false
)
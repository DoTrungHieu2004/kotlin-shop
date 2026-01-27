package com.hieu10.kotlinshop.viewmodel.state

import com.hieu10.kotlinshop.data.model.User

sealed interface AuthUIState {
    object Idle : AuthUIState
    object Loading : AuthUIState
    data class Success(val user: User) : AuthUIState
    data class Error(val message: String) : AuthUIState
}
package com.hieu10.kotlinshop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hieu10.kotlinshop.data.model.request.RegisterRequest
import com.hieu10.kotlinshop.data.repository.AuthRepository
import com.hieu10.kotlinshop.viewmodel.state.AuthUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<AuthUIState>(AuthUIState.Idle)
    val uiState: StateFlow<AuthUIState> = _uiState.asStateFlow()

    // Expose the token flow to check if user is already logged in
    val userToken: StateFlow<String?> = repository.userToken
        .stateIn(
            viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

    fun login(email: String, passwordHash: String) {
        viewModelScope.launch {
            _uiState.value = AuthUIState.Loading
            val result = repository.login(email, passwordHash)
            _uiState.value = result.fold(
                onSuccess = { AuthUIState.Success(it) },
                onFailure = { AuthUIState.Error(it.message ?: "Authentication failed") }
            )
        }
    }

    fun register(username: String, email: String, passwordHash: String, phone: String) {
        viewModelScope.launch {
            _uiState.value = AuthUIState.Loading
            val request = RegisterRequest(username, email, passwordHash, phone)
            val result = repository.register(request)
            _uiState.value = result.fold(
                onSuccess = { AuthUIState.Success(it) },
                onFailure = { AuthUIState.Error(it.message ?: "Registration failed") }
            )
        }
    }

    fun resetState() {
        _uiState.value = AuthUIState.Idle
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
            _uiState.value = AuthUIState.Idle
        }
    }
}
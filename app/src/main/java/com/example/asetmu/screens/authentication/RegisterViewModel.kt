package com.example.asetmu.screens.authentication

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.asetmu.domain.repositories.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) : ViewModel() {
    private val _name = mutableStateOf("")
    val name: State<String> = _name

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _submitSuccess = mutableStateOf(false)
    val submitSuccess: State<Boolean> = _submitSuccess

    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error

    fun onNameChange(newName: String) {
        _name.value = newName
    }

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun submit() {
        _isLoading.value = true
        _error.value = null
        viewModelScope.launch {
            val result = authenticationRepository.register(name.value,email.value, password.value)
            _isLoading.value = false
            result.onSuccess {
                _submitSuccess.value = true
            }.onFailure {
                _error.value = it.message ?: "An unknown error occurred"
                _submitSuccess.value = false
            }
        }
    }
}
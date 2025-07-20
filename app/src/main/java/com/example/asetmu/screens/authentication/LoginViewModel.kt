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
class LoginViewModel @Inject constructor(
	private val authenticationRepository: AuthenticationRepository
) : ViewModel() {

	private val _email = mutableStateOf("")
	val email: State<String> = _email

	private val _password = mutableStateOf("")
	val password: State<String> = _password

	private val _isLoading = mutableStateOf(false)
	val isLoading: State<Boolean> = _isLoading

	private val _loginSuccess = mutableStateOf(false)
	val loginSuccess: State<Boolean> = _loginSuccess

	private val _error = mutableStateOf<String?>(null)
	val error: State<String?> = _error

	fun onEmailChange(newEmail: String) {
		_email.value = newEmail
	}

	fun onPasswordChange(newPassword: String) {
		_password.value = newPassword
	}

	fun login() {
		_isLoading.value = true
		_error.value = null
		viewModelScope.launch {
			val result = authenticationRepository.login(email.value, password.value)
			_isLoading.value = false
			result.onSuccess {
				_loginSuccess.value = true
			}.onFailure {
				//! Set the appropriate error message if login fails
				_error.value = it.message ?: "An unknown error occurred"
				_loginSuccess.value = false
			}
		}
	}
}
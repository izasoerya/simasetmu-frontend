package com.example.asetmu.domain.services

import com.example.asetmu.domain.repositories.AuthenticationRepository
import javax.inject.Inject

class AuthenticationService @Inject constructor(
	private val authenticationRepository: AuthenticationRepository
){
	suspend fun login(email: String, password: String): Result<String> {
		return authenticationRepository.login(email, password)
	}

	suspend fun register(name: String, email: String, password: String): Result<String> {
		return authenticationRepository.register(name, email, password)
	}
}
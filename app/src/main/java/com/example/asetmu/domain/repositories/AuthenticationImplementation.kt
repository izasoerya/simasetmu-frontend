package com.example.asetmu.domain.repositories

import com.example.asetmu.data.dtos.LoginRequest
import com.example.asetmu.data.dtos.RegisterRequest
import com.example.asetmu.data.retrofit.AuthenticationController
import com.example.asetmu.utils.TokenManager
import javax.inject.Inject

class AuthenticationImplementation @Inject constructor(
		private val authController: AuthenticationController,
		private val tokenService: TokenManager
) : AuthenticationRepository{
	override suspend fun login(email: String, password: String): Result<String> {
		try {
			val result = authController.login(LoginRequest(email, password))
			if (result.isSuccessful) {
				val token = result.body()?.accessToken ?: return Result.failure(Exception("Token not found"))
				tokenService.saveAuthToken(token)
				return Result.success(token)
			} else {
				return Result.failure(Exception("Login failed: ${result.errorBody()?.string()}"))
			}
		} catch (e: Exception) {
			return Result.failure(e)
		}
	}
	override suspend fun register(
			name: String,
			email: String,
			password: String,
	): Result<String> {
		try {
		    val result = authController.register(RegisterRequest(name, email, password))
			if (result.isSuccessful) {
				return Result.success("Registration successful")
			}
			return Result.failure(Exception("Registration failed: ${result.errorBody()?.string()}"))
		} catch (e: Exception) {
			return Result.failure(e)
		}
	}

}
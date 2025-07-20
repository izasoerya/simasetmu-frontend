package com.example.asetmu.data.dtos

data class LoginResponse(
	val accessToken: String,
)

data class RegisterResponse(
	val email: String,
	val name: String,
)

data class LoginRequest(
	val email: String,
	val password: String,
)

data class RegisterRequest(
	val name: String,
	val email: String,
	val password: String,
)
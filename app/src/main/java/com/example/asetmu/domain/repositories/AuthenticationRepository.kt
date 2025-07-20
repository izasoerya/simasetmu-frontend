package com.example.asetmu.domain.repositories

interface AuthenticationRepository {
	suspend fun login(email: String, password: String): Result<String>
	suspend fun register(name: String, email: String, password: String): Result<String>
}
package com.example.asetmu.data.retrofit

import com.example.asetmu.data.dtos.LoginRequest
import com.example.asetmu.data.dtos.LoginResponse
import com.example.asetmu.data.dtos.RegisterRequest
import com.example.asetmu.data.dtos.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationController {
	@POST("auth/sign-in")
	suspend fun login(@Body request: LoginRequest) : Response<LoginResponse>
	@POST("auth/sign-up")
	suspend fun register(@Body request: RegisterRequest) : Response<RegisterResponse>
}
package com.example.asetmu.di

import com.example.asetmu.data.retrofit.AuthenticationController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
	@Provides
	@Singleton
	fun provideRetrofit(): Retrofit {
		return Retrofit.Builder()
			.baseUrl("http://10.0.2.2:7000/")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
	}

	@Provides
	@Singleton
	fun provideAuthenticationController(retrofit: Retrofit): AuthenticationController {
		return retrofit.create(AuthenticationController::class.java)
	}
}
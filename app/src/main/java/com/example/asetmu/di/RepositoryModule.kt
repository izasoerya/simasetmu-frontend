package com.example.asetmu.di

import com.example.asetmu.domain.repositories.AuthenticationImplementation
import com.example.asetmu.domain.repositories.AuthenticationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
	@Binds
	@Singleton
	abstract fun bindAuthenticationRepository(
			authenticationImplementation: AuthenticationImplementation
	): AuthenticationRepository
}
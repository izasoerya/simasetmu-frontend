package com.example.asetmu.utils

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import androidx.core.content.edit
import javax.inject.Singleton

@Singleton
class TokenManager @Inject constructor(
		@ApplicationContext private val context: Context,
){
	private val prefs: SharedPreferences = context.getSharedPreferences("auth_token", Context.MODE_PRIVATE)

	companion object {
		const val AUTH_TOKEN = "auth_token"
	}

	fun saveAuthToken(token: String) {
		prefs.edit { putString(AUTH_TOKEN, token) }
	}

	fun getAuthToken() : String? {
		return prefs.getString(AUTH_TOKEN, null)
	}

	fun clearAuthToken() {
		prefs.edit { remove(AUTH_TOKEN) }
	}
}
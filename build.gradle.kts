// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
	alias(libs.plugins.android.application) apply false
	alias(libs.plugins.kotlin.android) apply false
	alias(libs.plugins.kotlin.compose) apply false
	alias(libs.plugins.ksp) apply false
	alias(libs.plugins.hilt.android) apply false
	alias(libs.plugins.composeHotReload) apply false
}

buildscript {
	dependencies {
		classpath("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
	}
}
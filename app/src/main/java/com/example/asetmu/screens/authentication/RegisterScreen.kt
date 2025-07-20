package com.example.asetmu.screens.authentication

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.asetmu.screens.components.atom.GeneralTextField
import com.example.asetmu.ui.theme.AsetmuTheme // Your project's theme

@Composable
fun RegisterScreen(
		navController: NavController,
		viewModel: RegisterViewModel = hiltViewModel()
) {
	val context = LocalContext.current
	val name = viewModel.name.value
	val email = viewModel.email.value
	val password = viewModel.password.value
	val isLoading = viewModel.isLoading.value
	val registerSuccess = viewModel.submitSuccess.value
	val error = viewModel.error.value

	LaunchedEffect(registerSuccess) {
		if (registerSuccess) {
			navController.navigate("login_screen") {
				popUpTo("login_screen")
			}
			println("Register successful! Navigate to home screen.")
		}
	}

	LaunchedEffect(error) {
		if (error != null) {
			println("Login error: $error")
		}
	}

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(24.dp),
		horizontalAlignment = Alignment.Start,
		verticalArrangement = Arrangement.Center
	) {
		Text(
			text = "Daftar",
			style = MaterialTheme.typography.headlineLarge,
			fontFamily = FontFamily.SansSerif,
			fontWeight = FontWeight.Bold
		)
		Spacer(modifier = Modifier.height(32.dp))

		GeneralTextField(
			label = "Name",
			value = name,
			onChanged = { viewModel.onNameChange(it) },
		)
		Spacer(modifier = Modifier.height(8.dp))

		GeneralTextField(
			label = "Email",
			value = email,
			onChanged = { viewModel.onEmailChange(it) },
		)
		Spacer(modifier = Modifier.height(8.dp))

		GeneralTextField(
			label = "Password",
			value = password,
			onChanged = { viewModel.onPasswordChange(it) },
		)
		Spacer(modifier = Modifier.height(32.dp))

		Button(
			onClick = { viewModel.submit() },
			modifier = Modifier.fillMaxWidth(),
			enabled = !isLoading,
		) {
			if (isLoading) {
				CircularProgressIndicator(
					color = MaterialTheme.colorScheme.onPrimary,
					modifier = Modifier.size(24.dp)
				)
			} else {
				Text("Submit")
			}
		}

		Spacer(modifier = Modifier.height(16.dp))
		TextButton(
			onClick = {
				println("Go to Login Screen")
				navController.navigate("login_screen") {
					popUpTo("login_screen") { inclusive = true } // Clear the back stack
				}
			},
			modifier = Modifier.fillMaxWidth()
		) {
			Text(
				text = "Sudah punya akun? Masuk sekarang",
				style = MaterialTheme.typography.bodyMedium.copy(),
				color = Color.Gray.copy(alpha = 0.5f),
				fontFamily = FontFamily.SansSerif,
				fontWeight = FontWeight.Medium,
				textAlign = TextAlign.Center
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun RegistercreenPreview() {
	AsetmuTheme {
		RegisterScreen(navController = rememberNavController(), viewModel = viewModel()) // Use viewModel() for preview
	}
}
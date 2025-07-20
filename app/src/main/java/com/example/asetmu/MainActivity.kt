package com.example.asetmu

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.asetmu.screens.authentication.LoginScreen
import com.example.asetmu.screens.authentication.RegisterScreen
import com.example.asetmu.screens.dashboard.DashboardScreen
import com.example.asetmu.ui.theme.AsetmuTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	private val locationPermissionRequest =
		registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
			when {
				permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
					// Precise location access granted.
				}
				permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
					// Only approximate location access granted.
				}
				else -> {
					// No location access granted.
				}
			}
		}

	@RequiresApi(Build.VERSION_CODES.N)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		// Request location permissions
		locationPermissionRequest.launch(
			arrayOf(
				Manifest.permission.ACCESS_FINE_LOCATION,
				Manifest.permission.ACCESS_COARSE_LOCATION
			)
		)
		setContent {
			AsetmuTheme {
				val navController = rememberNavController()
				NavHost(
					navController = navController,
					startDestination = "login_screen",
				) {
					composable("login_screen") {
						LoginScreen(navController = navController)
					}
					composable("register_screen") {
						RegisterScreen(navController = navController)
					}
					composable("dashboard_screen") {
						DashboardScreen(navController = navController)
					}
				}
			}
		}
	}
}
package com.example.asetmu.screens.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.maps.android.compose.GoogleMap

@Composable
fun DashboardScreen(
	navController: NavController
) {
	Column(
		modifier = Modifier.fillMaxWidth()
	){
		GoogleMap {  }
		Button(onClick = { navController.navigate("login_screen") }) {}
		Text("Dashboard Screen", modifier = Modifier.fillMaxWidth())
	}
}
package com.example.asetmu.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Colors
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
	navController: NavController
) {
	val configuration = LocalConfiguration.current
	val screenWidth = configuration.screenWidthDp.dp
	val iconSize = remember { screenWidth * 0.05f }
	val sheetState = rememberModalBottomSheetState ()
	val showBottomSheet = remember { mutableStateOf(false) }

	Box(
		modifier = Modifier.fillMaxWidth()
	){
		GoogleMap (
			properties = MapProperties(
				isMyLocationEnabled = true,
				isBuildingEnabled = true,
			)
		)
		if (showBottomSheet.value) {
			ModalBottomSheet(
				onDismissRequest = { showBottomSheet.value = false },
				sheetState = sheetState,
			) { Text("Place Content Here") }
		}
		IconButton(
			onClick = { showBottomSheet.value = !showBottomSheet.value },
			modifier = Modifier
				.align(Alignment.BottomStart)
				.padding(20.dp)
				.background(
					color = Color.White,
					shape = RoundedCornerShape(10.dp)
				)
		) {
				Icon(
					imageVector = Icons.Default.KeyboardArrowUp,
					contentDescription = "Menu",
					modifier = Modifier.size(iconSize)
				)
		}
	}
}
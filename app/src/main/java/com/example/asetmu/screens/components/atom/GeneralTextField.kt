package com.example.asetmu.screens.components.atom

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.asetmu.ui.theme.AsetmuTheme

@Composable
fun GeneralTextField(
		label: String,
		value: String,
		onChanged: (String) -> Unit,
) {
	return OutlinedTextField(
		value = value,
		onValueChange = { onChanged(it) },
		label = { Text(label, style = MaterialTheme.typography.labelLarge, color = Color.Gray.copy(alpha = 0.7f)) },
		modifier = Modifier.fillMaxWidth(),
		shape = RoundedCornerShape(24.dp),
		colors = TextFieldDefaults.colors(
			unfocusedContainerColor = value .let {
				if (it.isEmpty()) Color.Gray.copy(alpha = 0.1f) else Color.White
			},
			focusedContainerColor = Color.White,
			unfocusedIndicatorColor = Color.Gray.copy(alpha = 0.1f),
			focusedIndicatorColor = Color.Gray.copy(alpha = 0.5f),
			focusedTextColor = Color.Black.copy(alpha = 0.8f),
			unfocusedTextColor = Color.Black.copy(alpha = 0.6f),
		)
	)
}

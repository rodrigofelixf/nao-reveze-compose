package br.com.rodrigo.naoreveze.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DetailScreen(segmentName: String) {
    if (segmentName.isNotBlank()) {
        when (segmentName) {
            "Peitoral" -> WorkoutScreen(segmentoNome = segmentName)
            "Costas" -> WorkoutScreen(segmentoNome = segmentName)
            "Pernas" -> WorkoutScreen(segmentoNome = segmentName)
        }

    } else {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Error, entre em contato com os desenvolvedores"

            )
        }
    }


}
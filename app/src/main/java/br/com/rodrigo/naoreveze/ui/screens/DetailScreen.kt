package br.com.rodrigo.naoreveze.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DetailScreen(segmentName: String) {
    if (segmentName.isNotBlank()) {
        when (segmentName) {
            "Peitoral" -> Text(text = "Voce clicou no: $segmentName")
            "Costas" -> Text(text = "Voce clicou no: $segmentName")
            "Pernas" -> Text(text = "Voce clicou no: $segmentName")
            else -> "Erro tela de detalhes"
        }

    } else {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Detalhes do segmento: $segmentName"

            )

            // Aqui você pode usar outros componentes do Compose para exibir outros detalhes do segmento
        }
    }


}
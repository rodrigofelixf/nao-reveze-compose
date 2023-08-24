package br.com.rodrigo.naoreveze.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.rodrigo.naoreveze.ui.theme.DeepBlue


@Composable
fun WorkoutScreen(text: String) {
    Box(
        modifier = androidx.compose.ui.Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(
                    bottom = 10.dp,
                    top = 10.dp
                )
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }

}
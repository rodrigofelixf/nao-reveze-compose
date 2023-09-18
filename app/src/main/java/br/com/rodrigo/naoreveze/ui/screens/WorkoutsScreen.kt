package br.com.rodrigo.naoreveze.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.rodrigo.naoreveze.model.Exercicios
import br.com.rodrigo.naoreveze.ui.theme.DeepBlue
import br.com.rodrigo.naoreveze.viewmodel.ExercicioViewModel


@Composable
fun WorkoutScreen(segmentoNome: String) {
    val exercicioViewModel: ExercicioViewModel = viewModel()
    
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
                text = segmentoNome,
                style = MaterialTheme.typography.headlineMedium
            )
            ExerciciosFeature(exercicios = exercicioViewModel.exerciciosState.collectAsState().value)
            
        }
    }

}

@Composable
fun ExerciciosFeature(exercicios: List<Exercicios>) {
    LazyColumn {
        items(exercicios.size) { item ->
            // Cada item é representado por um componente Compose
            ExerciciosCard(exercicios = exercicios[item])
        }
    }


}

@Composable
fun ExerciciosCard(exercicios: Exercicios) {
    Card(
        modifier = Modifier.padding(16.dp),
    ) {
        Text(text = exercicios.exercicioNome)
    }
}


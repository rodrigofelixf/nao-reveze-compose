package br.com.rodrigo.naoreveze.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rodrigo.naoreveze.model.Exercicios
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ExercicioViewModel : ViewModel() {
    val exerciciosState = MutableStateFlow<List<Exercicios>>(emptyList())

    init {
        loadExerciceFromFirestore()
    }

    private fun loadExerciceFromFirestore() {
        viewModelScope.launch {
            try {
                val firestore = Firebase.firestore
                val collection = firestore.collection("Exercicios")
                val querySnapshot = collection.get().await()

                val exercicios = querySnapshot.documents.mapNotNull { document ->
                    document.toObject(Exercicios::class.java)
                }

                exerciciosState.value = exercicios
            } catch (e: Exception) {
                // Tratar erros aqui
            }
        }
    }
}

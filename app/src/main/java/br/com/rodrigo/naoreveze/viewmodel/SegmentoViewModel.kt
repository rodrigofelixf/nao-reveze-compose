import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class SegmentoViewModel : ViewModel() {
    val segmentsState = MutableStateFlow<List<Segmentos>>(emptyList())

    init {
        loadSegmentsFromFirestore()
    }

    private fun loadSegmentsFromFirestore() {
        viewModelScope.launch {
            try {
                val firestore = Firebase.firestore
                val collection = firestore.collection("Segmentos")
                val querySnapshot = collection.get().await()

                val segments = querySnapshot.documents.mapNotNull { document ->
                    document.toObject(Segmentos::class.java)
                }

                segmentsState.value = segments
            } catch (e: Exception) {
                // Tratar erros aqui
            }
        }
    }
}

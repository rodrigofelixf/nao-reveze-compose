package br.com.rodrigo.naoreveze

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.rodrigo.naoreveze.ui.theme.NaoRevezeTheme


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NaoRevezeTheme {
                HomeScreen()
            }
        }
    }
}


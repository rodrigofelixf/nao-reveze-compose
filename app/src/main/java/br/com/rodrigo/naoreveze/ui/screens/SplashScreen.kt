package br.com.rodrigo.naoreveze.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.rodrigo.naoreveze.NavigationScreens
import br.com.rodrigo.naoreveze.R
import br.com.rodrigo.naoreveze.model.DestinationScreen
import br.com.rodrigo.naoreveze.ui.theme.DeepBlue
import br.com.rodrigo.naoreveze.ui.theme.NaoRevezeTheme
import java.util.logging.Handler

@Composable
fun SplashScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        // Lógica da tela de splash (imagem, animações, etc.)
        Image(
            painter = painterResource(id = R.drawable.icone_logo),
            contentDescription = null,
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.Fit
        )

        // Simulando um atraso de 2 segundos para a SplashScreen
        LaunchedEffect(true) {
            kotlinx.coroutines.delay(2000)
            navController.navigate(DestinationScreen.NavigationScreen.route) {
                popUpTo(DestinationScreen.Splash.route) { inclusive = true }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    NaoRevezeTheme {
       SplashScreen(navController = rememberNavController())
    }
}


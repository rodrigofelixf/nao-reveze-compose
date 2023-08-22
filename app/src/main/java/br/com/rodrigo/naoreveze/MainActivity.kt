package br.com.rodrigo.naoreveze

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.Composable

import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.rodrigo.naoreveze.model.DestinationScreen
import br.com.rodrigo.naoreveze.ui.screens.DetailScreen
import br.com.rodrigo.naoreveze.ui.screens.HomeScreen
import br.com.rodrigo.naoreveze.ui.theme.NaoRevezeTheme


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NaoRevezeTheme {
                NavigationScreens()
            }
        }
    }
}

@Composable
fun NavigationScreens() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable(DestinationScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(
            DestinationScreen.Detail.route,
            arguments = listOf(navArgument("segmentName") { type = NavType.StringType })
        ) { backStackEntry ->
            val segmentName = backStackEntry.arguments?.getString("segmentName") ?: ""
            DetailScreen(segmentName)
        }


    }
}





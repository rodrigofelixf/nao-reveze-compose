package br.com.rodrigo.naoreveze

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut

import androidx.compose.runtime.Composable

import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.rodrigo.naoreveze.model.DestinationScreen
import br.com.rodrigo.naoreveze.ui.screens.DetailScreen
import br.com.rodrigo.naoreveze.ui.screens.HomeScreen
import br.com.rodrigo.naoreveze.ui.screens.SplashScreen
import br.com.rodrigo.naoreveze.ui.theme.NaoRevezeTheme


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NaoRevezeTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = DestinationScreen.Splash.route
                ) {
                    composable(DestinationScreen.Splash.route) {
                        SplashScreen(navController = navController)
                    }
                    composable(route = DestinationScreen.NavigationScreen.route) {
                        NavigationScreens()
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationScreens() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable(route = DestinationScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(
            route = DestinationScreen.Detail.route,
            arguments = listOf(navArgument("segmentName") { type = NavType.StringType }),
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            }
        ) { backStackEntry ->
            val segmentName = backStackEntry.arguments?.getString("segmentName") ?: ""
            DetailScreen(segmentName)
        }


    }
}





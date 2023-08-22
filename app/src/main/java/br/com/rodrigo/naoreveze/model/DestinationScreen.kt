package br.com.rodrigo.naoreveze.model

sealed class DestinationScreen(val route: String) {
    object Home: DestinationScreen("home")
    object Detail: DestinationScreen("detail/{segmentName}")

}
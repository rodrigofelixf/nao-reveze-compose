package br.com.rodrigo.naoreveze.model

sealed class Destination(val route: String) {
    object Home: Destination("home")
    object Detail: Destination("detail/{segmentName}")

}

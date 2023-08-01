package br.com.rodrigo.naoreveze.model

import androidx.annotation.DrawableRes


data class BottomMenuContent(
    val title: String,
    @DrawableRes val iconId: Int
)

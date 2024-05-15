package com.garif.coffees.domain.model

import androidx.annotation.DrawableRes
import com.garif.coffees.R

data class Coffee(
    @DrawableRes val photoResource: Int = R.drawable.first_coffee,
    val coffeeName: String = "Капучино эконом",
    val volume: Double = 0.33,
    val price: String = "199 ₽",
)

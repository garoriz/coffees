package com.garif.coffees.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val LocalDim = compositionLocalOf { Dimensions() }

data class Dimensions(
    val dpMinus44: Dp = (-44).dp,
    val dpMinus10: Dp = (-10).dp,
    val dp1: Dp = 1.dp,
    val dp10: Dp = 10.dp,
    val dp12: Dp = 12.dp,
    val dp16: Dp = 16.dp,
    val dp20: Dp = 20.dp,
    val dp24: Dp = 24.dp,
    val dp26: Dp = 26.dp,
)

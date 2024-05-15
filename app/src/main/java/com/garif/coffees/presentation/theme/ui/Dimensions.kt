package com.garif.coffees.presentation.theme.ui

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val LocalDim = compositionLocalOf { Dimensions() }

data class Dimensions(
    val dpMinus44: Dp = (-44).dp,
    val dpMinus10: Dp = (-10).dp,
    val dp0: Dp = 0.dp,
    val dp1: Dp = 1.dp,
    val dp6: Dp = 6.dp,
    val dp8: Dp = 8.dp,
    val dp10: Dp = 10.dp,
    val dp12: Dp = 12.dp,
    val dp16: Dp = 16.dp,
    val dp20: Dp = 20.dp,
    val dp24: Dp = 24.dp,
    val dp26: Dp = 26.dp,
    val dp56: Dp = 56.dp,
    val dp210: Dp = 210.dp,
    val dp228: Dp = 228.dp,
)

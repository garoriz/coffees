package com.garif.coffees.presentation.util

sealed class Screen(val route: String) {
    object CatalogScreen: Screen("catalog_screen")
    object DrinkSettingsScreen: Screen("drink_settings_screen")
}
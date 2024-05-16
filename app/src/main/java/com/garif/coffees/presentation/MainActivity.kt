package com.garif.coffees.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.garif.coffees.R
import com.garif.coffees.presentation.catalog.composables.CatalogScreen
import com.garif.coffees.presentation.composables.TopBar
import com.garif.coffees.presentation.drinksettings.composables.DrinkSettingsScreen
import com.garif.coffees.presentation.theme.ui.CoffeesTheme
import com.garif.coffees.presentation.util.Screen


class MainActivity : ComponentActivity() {
    val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeesTheme(dynamicColor = false) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black),
                ) { innerPadding ->
                    val navController = rememberNavController()

                    Column(verticalArrangement = Arrangement.SpaceBetween) {
                        TopBar(
                            innerPadding = innerPadding,
                            time = viewModel.state.value.time,
                            temperature = viewModel.state.value.temperature.toString() + getString(R.string.degree),
                            navController = navController,
                            viewModel = viewModel
                        )

                        NavHost(
                            navController = navController,
                            startDestination = Screen.CatalogScreen.route
                        ) {
                            composable(route = Screen.CatalogScreen.route) {
                                CatalogScreen()
                            }
                            composable(route = Screen.DrinkSettingsScreen.route) {
                                DrinkSettingsScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}

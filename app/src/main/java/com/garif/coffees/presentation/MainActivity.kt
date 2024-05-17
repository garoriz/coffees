package com.garif.coffees.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.garif.coffees.R
import com.garif.coffees.di.DaggerMainActivityComponent
import com.garif.coffees.presentation.catalog.composables.CatalogScreen
import com.garif.coffees.presentation.composables.TopBar
import com.garif.coffees.presentation.drinksettings.composables.DrinkSettingsScreen
import com.garif.coffees.presentation.theme.ui.CoffeesTheme
import com.garif.coffees.presentation.util.Screen
import com.garif.coffees.utils.daggerViewModel


class MainActivity : ComponentActivity() {

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
                    val component = DaggerMainActivityComponent.builder().build()

                    val viewModel: MainViewModel = daggerViewModel {
                        Log.i("LOG", "create VM: MainViewModel")

                        component.getViewModel()
                    }

                    LaunchedEffect(true) {
                        viewModel.update()
                    }

                    Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(innerPadding)) {
                        TopBar(
                            time = viewModel.state.value.time,
                            temperature = viewModel.state.value.temperature.toString() + getString(R.string.degree),
                            navController = navController
                        )

                        NavHost(
                            navController = navController,
                            startDestination = Screen.CatalogScreen.route
                        ) {
                            composable(route = Screen.CatalogScreen.route) {
                                CatalogScreen()
                            }
                            composable(route = Screen.DrinkSettingsScreen.route) {
                                DrinkSettingsScreen(navController)
                            }
                        }
                    }
                }
            }
        }
    }
}

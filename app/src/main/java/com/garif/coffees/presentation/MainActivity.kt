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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
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
import java.util.Calendar
import java.util.Locale
import java.util.Timer
import java.util.TimerTask


class MainActivity : ComponentActivity() {
    private val timer = Timer()
    private var c = Calendar.getInstance()
    private var hrs = c.get(Calendar.HOUR_OF_DAY)
    private var min = c.get(Calendar.MINUTE)
    private var sec = c.get(Calendar.SECOND)
    private var timeState = mutableStateOf(getFormattedTime())

    private fun getFormattedTime(): String {
        val formattedHrs = String.format("%02d", c.get(Calendar.HOUR_OF_DAY))
        val formattedMin = String.format("%02d", c.get(Calendar.MINUTE))
        return "$formattedHrs:$formattedMin"
    }

    private var temperatureState = mutableIntStateOf((85..95).random())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        updateTimeOnEachMinute()
        updateTemperature()
        val time by timeState
        val temperature by temperatureState
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
                            time = time,
                            temperature = temperature.toString() + getString(R.string.degree),
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
                                DrinkSettingsScreen()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun updateTimeOnEachMinute() {
        timer.schedule(object : TimerTask() {
            override fun run() {
                c = Calendar.getInstance()
                hrs = c.get(Calendar.HOUR_OF_DAY)
                min = c.get(Calendar.MINUTE)
                timeState.value = getFormattedTime()
            }
        }, 0, 60000)
    }

    private fun updateTemperature() {
        timer.schedule(object : TimerTask() {
            override fun run() {
                c = Calendar.getInstance()
                val newSec = c.get(Calendar.SECOND)
                if (sec != newSec) {
                    sec = newSec
                    temperatureState.value = (85..95).random()
                }
            }
        }, 0, 100)
    }
}

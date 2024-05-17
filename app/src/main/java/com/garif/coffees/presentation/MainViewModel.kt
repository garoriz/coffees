package com.garif.coffees.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.garif.coffees.presentation.util.getFormattedTime
import java.util.Calendar
import java.util.Timer
import java.util.TimerTask

class MainViewModel : ViewModel() {
    private val timer = Timer()
    private var c = Calendar.getInstance()
    private var hrs = c.get(Calendar.HOUR_OF_DAY)
    private var min = c.get(Calendar.MINUTE)
    private var sec = c.get(Calendar.SECOND)

    private val _state = mutableStateOf(MainState())
    val state: State<MainState> = _state

    fun update() {
        updateTimeOnEachMinute()
        updateTemperature()
    }

    private fun updateTimeOnEachMinute() {
        timer.schedule(object : TimerTask() {
            override fun run() {
                c = Calendar.getInstance()
                hrs = c.get(Calendar.HOUR_OF_DAY)
                min = c.get(Calendar.MINUTE)
                _state.value = state.value.copy(
                    time = getFormattedTime(c)
                )
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
                    _state.value = state.value.copy(
                        temperature = (85..95).random()
                    )
                }
            }
        }, 0, 100)
    }
}
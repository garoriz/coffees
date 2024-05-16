package com.garif.coffees.presentation.catalog

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CatalogViewModel : ViewModel() {
    private val _state = mutableStateOf(Coffees())
    val state: State<Coffees> = _state
}
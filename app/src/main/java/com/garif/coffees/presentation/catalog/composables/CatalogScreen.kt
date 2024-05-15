package com.garif.coffees.presentation.catalog.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.garif.coffees.domain.model.Coffee
import com.garif.coffees.presentation.theme.ui.LocalDim

@Composable
fun CatalogScreen() {
    val data = listOf(
        Coffee(),
        Coffee(),
        Coffee(),
        Coffee(),
        Coffee(),
        Coffee(),
        Coffee(),
        Coffee(),
        Coffee(),
        Coffee(),
        Coffee(),
        Coffee(),
        Coffee(),
        Coffee(),
        Coffee(),
        Coffee(),
        Coffee(),
        Coffee(),
        Coffee(),
        Coffee(),
    )


    CoffeeList(data, Modifier.padding(bottom = LocalDim.current.dp24))
}
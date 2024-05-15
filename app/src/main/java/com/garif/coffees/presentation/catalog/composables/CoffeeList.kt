package com.garif.coffees.presentation.catalog.composables

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.garif.coffees.domain.model.Coffee
import com.garif.coffees.presentation.theme.ui.LocalDim

@Composable
fun CoffeeList(
    list: List<Coffee>,
    modifier: Modifier,
) {
    LazyVerticalGrid(columns = GridCells.Adaptive(LocalDim.current.dp228), modifier = modifier) {
        items(list.size) {
            CoffeeTile(Coffee())
        }
    }
}

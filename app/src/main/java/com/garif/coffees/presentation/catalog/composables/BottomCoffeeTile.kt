package com.garif.coffees.presentation.catalog.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.garif.coffees.domain.model.Coffee
import com.garif.coffees.presentation.theme.ui.BottomTileColor
import com.garif.coffees.presentation.theme.ui.LocalDim

@Composable
fun BottomCoffeeTile(coffee: Coffee) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(BottomTileColor),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = coffee.volume.toString(),
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(
                top = LocalDim.current.dp8,
                bottom = LocalDim.current.dp8,
                start = LocalDim.current.dp16,
            )
        )
        Text(
            text = coffee.price,
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(
                top = LocalDim.current.dp8,
                bottom = LocalDim.current.dp8,
                end = LocalDim.current.dp16,
            )
        )
    }
}
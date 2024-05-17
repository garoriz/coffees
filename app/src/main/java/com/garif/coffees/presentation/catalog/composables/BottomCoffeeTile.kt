package com.garif.coffees.presentation.catalog.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.garif.coffees.R
import com.garif.coffees.domain.model.Coffee
import com.garif.coffees.presentation.theme.ui.BottomTileColor
import com.garif.coffees.presentation.theme.ui.LocalDim

@Composable
fun BottomCoffeeTile(coffee: Coffee, isFreeDrink: Boolean) {
    val rub = stringResource(id = R.string.rub)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(BottomTileColor)
            .padding(
                vertical = LocalDim.current.dp8,
                horizontal = LocalDim.current.dp16
            ),
        horizontalArrangement = (
                if (isFreeDrink) Arrangement.Center
                else Arrangement.SpaceBetween
                )
    ) {
        Text(
            text = coffee.volume.toString(),
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center,
        )
        AnimatedVisibility(visible = !isFreeDrink) {
            Text(
                text = coffee.price + " $rub",
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center,
            )
        }
    }
}
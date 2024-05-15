package com.garif.coffees.presentation.catalog.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.garif.coffees.domain.model.Coffee
import com.garif.coffees.presentation.theme.ui.BackgroundTileColor
import com.garif.coffees.presentation.theme.ui.LocalDim

@Composable
fun CoffeeTile(coffee: Coffee) {
    Card(
        shape = RoundedCornerShape(LocalDim.current.dp6),
        modifier = Modifier
            .padding(
                top = LocalDim.current.dp24,
                start = LocalDim.current.dp24,
                end = LocalDim.current.dp24
            ),
        colors = CardDefaults.cardColors(
            containerColor = BackgroundTileColor,
            //contentColor = Color.White
        )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = coffee.photoResource),
                contentDescription = null,
                alignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = LocalDim.current.dp8, end = LocalDim.current.dp8)
                    .size(LocalDim.current.dp210)
            )
            Text(
                text = coffee.coffeeName,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.height(LocalDim.current.dp56)
            )
            BottomCoffeeTile(coffee)
        }
    }
}
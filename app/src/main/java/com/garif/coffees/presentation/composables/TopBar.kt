package com.garif.coffees.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.garif.coffees.R
import com.garif.coffees.presentation.theme.ui.BorderColor
import com.garif.coffees.presentation.theme.ui.LocalDim
import com.garif.coffees.presentation.util.Screen

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    time: String,
    temperature: String,
    navController: NavController,
) {
    Column {
        TopRow(
            modifier = Modifier
                .padding(innerPadding)
                .offset(y = LocalDim.current.dp16),
            time,
            temperature,
            navController
        )
        Divider(
            color = BorderColor,
            modifier = Modifier
                .height(LocalDim.current.dp1)
                .fillMaxWidth()
        )
    }
}

@Composable
fun TopRow(
    modifier: Modifier = Modifier,
    time: String,
    temperature: String,
    navController: NavController,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = LocalDim.current.dp26,
                end = LocalDim.current.dp26,
                bottom = LocalDim.current.dp16
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        TopLeftRow(navController)
        TopRightRow(time, temperature)
    }
}

@Composable
fun TopLeftRow(navController: NavController) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.runero_logo),
            contentDescription = null,
            modifier = Modifier
                .size(LocalDim.current.dp24)
        )
        ClickableText(
            text = AnnotatedString(stringResource(id = R.string.runero)),
            modifier = Modifier
                .offset(x = LocalDim.current.dp12),
            style = MaterialTheme.typography.titleSmall,
            onClick = {
                navController.navigate(Screen.DrinkSettingsScreen.route)
            }
        )
        Text(
            text = stringResource(id = R.string.touch),
            modifier = Modifier
                .offset(x = LocalDim.current.dp16),
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun TopRightRow(time: String, temperature: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = time,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(start = LocalDim.current.dp24, end = LocalDim.current.dp24)
        )
        Degrees(temperature)
        Language()
    }
}

@Composable
fun Degrees(temperature: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = LocalDim.current.dp24, end = LocalDim.current.dp24)
    ) {
        Text(
            text = temperature,
            style = MaterialTheme.typography.labelSmall,
        )
        Image(
            painter = painterResource(id = R.drawable.water),
            contentDescription = null,
            modifier = Modifier
                .size(LocalDim.current.dp10)
        )
    }
}

@Composable
fun Language() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = LocalDim.current.dp24, end = LocalDim.current.dp24)
    ) {
        Image(
            painter = painterResource(id = R.drawable.russia),
            contentDescription = null,
            modifier = Modifier
                .size(LocalDim.current.dp10)
                .offset(x = LocalDim.current.dpMinus10)
        )
        Text(
            text = stringResource(id = R.string.ru),
            style = MaterialTheme.typography.labelSmall
        )
    }
}
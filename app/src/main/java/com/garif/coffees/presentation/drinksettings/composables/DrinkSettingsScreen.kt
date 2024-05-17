package com.garif.coffees.presentation.drinksettings.composables

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.garif.coffees.R
import com.garif.coffees.presentation.theme.ui.BorderColor
import com.garif.coffees.presentation.theme.ui.BtnColor
import com.garif.coffees.presentation.theme.ui.LocalDim
import com.garif.coffees.presentation.theme.ui.SwitchColor
import com.garif.coffees.presentation.theme.ui.TextFieldBgColor
import com.garif.coffees.presentation.util.GradientSwitch
import com.garif.coffees.presentation.util.Screen
import com.garif.coffees.presentation.util.getActivity

@Composable
fun DrinkSettingsScreen(navController: NavController) {
    val context = LocalContext.current
    val activity = context.getActivity()
    val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
    val spTitle = stringResource(id = R.string.sp_title)
    val title = sharedPref.getString(
        spTitle,
        stringResource(id = R.string.amaretto_coffee)
    ) ?: spTitle
    var titleState by remember { mutableStateOf(TextFieldValue(title)) }
    val spPrice = stringResource(id = R.string.sp_price)
    val price = sharedPref.getString(
        spPrice,
        stringResource(id = R.string._199)
    ) ?: spPrice
    var priceState by remember { mutableStateOf(TextFieldValue(price)) }
    val spIsFreeDrink = stringResource(id = R.string.is_free_drink)
    val isFreeDrink = sharedPref.getBoolean(spIsFreeDrink, false)
    val isFreeDrinkState = remember { mutableStateOf(isFreeDrink) }
    val spIsCreamCappuccino = stringResource(id = R.string.is_cream_cappuccino)
    val isCreamCappuccino =
        sharedPref.getBoolean(spIsCreamCappuccino, true)
    val isCreamCappuccinoState = remember { mutableStateOf(isCreamCappuccino) }
    val spIsMokkachino = stringResource(id = R.string.is_mokkachino)
    val isMokkachino = sharedPref.getBoolean(spIsMokkachino, false)
    val isMokkachinoState = remember { mutableStateOf(isMokkachino) }
    val isEnabledSaveBtn = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                end = LocalDim.current.dp30,
                bottom = LocalDim.current.dp182
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.title),
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.Center,
            )
            TextField(
                value = titleState,
                onValueChange = {
                    titleState = it
                    checkOldAndNewValues(it.text, title, isEnabledSaveBtn)
                },
                shape = RoundedCornerShape(LocalDim.current.dp6),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedContainerColor = TextFieldBgColor,
                    unfocusedContainerColor = TextFieldBgColor
                ),
                textStyle = MaterialTheme.typography.displayLarge,
                singleLine = true,
                modifier = Modifier
                    .requiredWidth(LocalDim.current.dp418)
                    .offset(y = LocalDim.current.dp12)
            )
            Text(
                text = stringResource(id = R.string.price),
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .height(LocalDim.current.dp56)
                    .offset(y = LocalDim.current.dp48)
            )
            TextField(
                value = priceState,
                onValueChange = {
                    priceState = it
                    checkOldAndNewValues(it.text, price, isEnabledSaveBtn)
                },
                shape = RoundedCornerShape(LocalDim.current.dp6),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedContainerColor = TextFieldBgColor,
                    unfocusedContainerColor = TextFieldBgColor
                ),
                textStyle = MaterialTheme.typography.displayLarge,
                singleLine = true,
                modifier = Modifier
                    .requiredWidth(LocalDim.current.dp418)
                    .offset(y = LocalDim.current.dp28),
                suffix = {
                    Text(
                        text = stringResource(id = R.string.rub),
                        style = MaterialTheme.typography.labelLarge
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.NumberPassword
                ),
            )
            Row(
                modifier = Modifier
                    .offset(y = LocalDim.current.dp40)
                    .height(LocalDim.current.dp48)
                    .width(LocalDim.current.dp418)
                    .border(
                        BorderStroke(LocalDim.current.dp1, BorderColor),
                        shape = RoundedCornerShape(LocalDim.current.dp12)
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.sell_for_free),
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.offset(x = LocalDim.current.dp24)
                )
                GradientSwitch(
                    checked = isFreeDrinkState.value,
                    onCheckedChange = {
                        isFreeDrinkState.value = it
                        checkOldAndNewValues(it, isFreeDrink, isEnabledSaveBtn)
                    },
                    modifier = Modifier
                        .offset(x = LocalDim.current.dpMinus24)
                        .scale(0.8f),
                    checkedTrackColor = SwitchColor
                )
            }
            Button(
                onClick = {
                    save(
                        sharedPref,
                        spTitle,
                        titleState.text,
                        spPrice,
                        priceState.text,
                        spIsFreeDrink,
                        isFreeDrinkState.value,
                        spIsCreamCappuccino,
                        isCreamCappuccinoState.value,
                        spIsMokkachino,
                        isMokkachinoState.value
                    )
                    navController.navigate(Screen.CatalogScreen.route)
                },
                shape = RoundedCornerShape(LocalDim.current.dp12),
                colors = ButtonDefaults.buttonColors(
                    containerColor = BtnColor,
                    disabledContainerColor = BtnColor
                ),
                modifier = Modifier
                    .offset(y = LocalDim.current.dp80),
                contentPadding = PaddingValues(
                    vertical = LocalDim.current.dp16,
                    horizontal = LocalDim.current.dp24
                ),
                enabled = isEnabledSaveBtn.value
            ) {
                Text(
                    text = stringResource(id = R.string.save),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.cream_cappuccino),
                contentDescription = null,
                modifier = Modifier
                    .size(LocalDim.current.dp288)
                    .toggleable(
                        value = isCreamCappuccinoState.value,
                        onValueChange = {
                            isCreamCappuccinoState.value = it
                            isMokkachinoState.value = !it
                            checkOldAndNewValues(it, isCreamCappuccino, isEnabledSaveBtn)
                        })
                    .alpha(
                        if (isCreamCappuccinoState.value) 1f
                        else 0.3f
                    )
            )
            Image(
                painter = painterResource(id = R.drawable.check_coffee),
                contentDescription = null,
                modifier = Modifier
                    .offset(y = LocalDim.current.dpMinus58)
                    .size(LocalDim.current.dp32)
                    .alpha(
                        if (isCreamCappuccinoState.value) 1f
                        else 0f
                    ),
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.mokkachino),
                contentDescription = null,
                modifier = Modifier
                    .size(LocalDim.current.dp288)
                    .offset(y = LocalDim.current.dp16)
                    .toggleable(
                        value = isMokkachinoState.value,
                        onValueChange = {
                            isMokkachinoState.value = it
                            isCreamCappuccinoState.value = !it
                            checkOldAndNewValues(it, isMokkachino, isEnabledSaveBtn)
                        })
                    .alpha(
                        if (isMokkachinoState.value) 1f
                        else 0.3f
                    )
            )
            Image(
                painter = painterResource(id = R.drawable.check_coffee),
                contentDescription = null,
                modifier = Modifier
                    .offset(y = LocalDim.current.dpMinus58)
                    .size(LocalDim.current.dp32)
                    .alpha(
                        if (isMokkachinoState.value) 1f
                        else 0f
                    ),
            )
        }
    }
}

fun save(
    sharedPref: SharedPreferences,
    spTitle: String,
    title: String,
    spPrice: String,
    price: String,
    spIsFreeDrink: String,
    isFreeDrink: Boolean,
    spIsCreamCappuccino: String,
    isCreamCappuccino: Boolean,
    spIsMokkachino: String,
    isMokkachino: Boolean,
) {
    with(sharedPref.edit()) {
        putString(spTitle, title)
        putString(spPrice, price)
        putBoolean(spIsFreeDrink, isFreeDrink)
        putBoolean(spIsCreamCappuccino, isCreamCappuccino)
        putBoolean(spIsMokkachino, isMokkachino)
        apply()
    }
}

fun checkOldAndNewValues(
    newValue: Any,
    oldValue: Any?,
    isEnabledSaveBtn: MutableState<Boolean>,
) {
    if (newValue != oldValue)
        isEnabledSaveBtn.value = true
    else
        isEnabledSaveBtn.value = false
}

package com.garif.coffees.presentation.catalog.composables

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import com.garif.coffees.R
import com.garif.coffees.presentation.catalog.CatalogViewModel
import com.garif.coffees.presentation.theme.ui.LocalDim
import com.garif.coffees.presentation.util.getActivity

@Composable
fun CatalogScreen() {
    val viewModel = CatalogViewModel()

    val context = LocalContext.current
    val activity = context.getActivity()
    val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
    val title = sharedPref.getString(
        stringResource(id = R.string.sp_title),
        stringResource(id = R.string.amaretto_coffee)
    )
    var titleState by remember { mutableStateOf(title?.let { TextFieldValue(it) }) }
    val price = sharedPref.getString(
        stringResource(id = R.string.sp_price),
        stringResource(id = R.string._199)
    )
    var priceState by remember { mutableStateOf(price?.let { TextFieldValue(it) }) }
    val isFreeDrink = sharedPref.getBoolean(stringResource(id = R.string.is_free_drink), false)
    val isFreeDrinkState = remember { mutableStateOf(isFreeDrink) }
    val isCreamCappuccino =
        sharedPref.getBoolean(stringResource(id = R.string.is_cream_cappuccino), true)
    val isCreamCappuccinoState = remember { mutableStateOf(isCreamCappuccino) }
    val isMokkachino = sharedPref.getBoolean(stringResource(id = R.string.is_mokkachno), false)
    val isMokkachinoState = remember { mutableStateOf(isMokkachino) }




    CoffeeList(viewModel.state.value.data, Modifier.padding(bottom = LocalDim.current.dp24))
}
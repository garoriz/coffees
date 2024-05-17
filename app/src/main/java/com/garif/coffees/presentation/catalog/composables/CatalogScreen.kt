package com.garif.coffees.presentation.catalog.composables

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.garif.coffees.R
import com.garif.coffees.presentation.catalog.Coffees
import com.garif.coffees.presentation.util.getActivity

@Composable
fun CatalogScreen() {

    val context = LocalContext.current
    val activity = context.getActivity()
    val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
    val title = sharedPref.getString(
        stringResource(id = R.string.sp_title),
        stringResource(id = R.string.amaretto_coffee)
    ) ?: stringResource(id = R.string.amaretto_coffee)
    val price = sharedPref.getString(
        stringResource(id = R.string.sp_price),
        stringResource(id = R.string._199)
    ) ?: stringResource(id = R.string._199)
    val isFreeDrink = sharedPref.getBoolean(stringResource(id = R.string.is_free_drink), false)
    remember { mutableStateOf(isFreeDrink) }
    val isCreamCappuccino =
        sharedPref.getBoolean(stringResource(id = R.string.is_cream_cappuccino), true)
    remember { mutableStateOf(isCreamCappuccino) }
    val isMokkachino = sharedPref.getBoolean(stringResource(id = R.string.is_mokkachino), false)
    remember { mutableStateOf(isMokkachino) }




    CoffeeList(
        Coffees(
            if (isCreamCappuccino)
                R.drawable.cream_cappuccino
            else
                R.drawable.mokkachino,
            title,
            price,
            isFreeDrink
        ).data, Modifier, isFreeDrink
    )
}
package com.garif.coffees.presentation.drinksettings.composables

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import com.garif.coffees.R
import com.garif.coffees.presentation.theme.ui.LocalDim
import com.garif.coffees.presentation.theme.ui.TextFieldColor
import com.garif.coffees.presentation.util.getActivity

@Composable
fun DrinkSettingsScreen() {
    val context = LocalContext.current
    val activity = context.getActivity()
    val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
    val title = sharedPref.getString(stringResource(id = R.string.sp_title), "")
    var titleState by remember { mutableStateOf(title?.let { TextFieldValue(it) }) }

    Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = R.string.title),
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.height(LocalDim.current.dp56)
            )
            titleState?.let {
                TextField(
                    value = it,
                    onValueChange = { titleState = it },
                    shape = RoundedCornerShape(LocalDim.current.dp6),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        focusedContainerColor = TextFieldColor,
                        unfocusedContainerColor = TextFieldColor
                    ),
                )
            }
        }
    }
}
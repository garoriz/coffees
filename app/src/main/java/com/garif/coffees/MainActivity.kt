package com.garif.coffees

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.garif.coffees.ui.theme.BorderColor
import com.garif.coffees.ui.theme.CoffeesTheme
import com.garif.coffees.ui.theme.LocalDim
import java.util.Calendar
import java.util.Timer
import java.util.TimerTask


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeesTheme(dynamicColor = false) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                ) { innerPadding ->
                    Column {
                        TopRow(
                            modifier = Modifier
                                .padding(innerPadding)
                                .offset(y = LocalDim.current.dp16)
                        )
                        Divider(
                            color = BorderColor,
                            modifier = Modifier
                                .height(LocalDim.current.dp1)
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

fun updateTimeOnEachMinute() {
    val timer = Timer()
    timer.schedule(object : TimerTask() {
        override fun run() {
            val c = Calendar.getInstance()
            Log.d("myapp", "time changed")
            val hrs = c.get(Calendar.HOUR_OF_DAY)
            val min = c.get(Calendar.MINUTE)

            /*runOnUiThread(Runnable {
                println(String.valueOf(hrs) + ":" + String.valueOf(min))
            })*/
        }
    }, 0, 1000)
}

@Composable
fun TopRow(modifier: Modifier = Modifier) {
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
        TopLeftRow()
        TopRightRow()
    }
}

@Composable
fun TopLeftRow() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.runero_logo),
            contentDescription = null,
            modifier = Modifier
                .size(LocalDim.current.dp24)
        )
        Text(
            text = stringResource(id = R.string.runero_touch),
            modifier = Modifier
                .offset(x = LocalDim.current.dp12),
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun TopRightRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(start = LocalDim.current.dp24, end = LocalDim.current.dp24)
        )
        Degrees()
        Language()
    }
}

@Composable
fun Degrees() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = LocalDim.current.dp24, end = LocalDim.current.dp24)
    ) {
        Text(
            text = stringResource(id = R.string.degrees_85),
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoffeesTheme {
        TopRow()
    }
}
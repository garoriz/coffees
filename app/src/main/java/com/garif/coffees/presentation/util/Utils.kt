package com.garif.coffees.presentation.util

import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import java.util.Calendar

fun Context.getActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}

fun getFormattedTime(c: Calendar): String {
    val formattedHrs = String.format("%02d", c.get(Calendar.HOUR_OF_DAY))
    val formattedMin = String.format("%02d", c.get(Calendar.MINUTE))
    return "$formattedHrs:$formattedMin"
}
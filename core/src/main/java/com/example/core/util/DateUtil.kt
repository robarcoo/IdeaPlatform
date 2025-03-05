package com.example.core.util

import java.util.Calendar
import java.util.Locale

fun getDate(ts : Long?) : String {
    if (ts == null) return ""
    val calendar = Calendar.getInstance(Locale.getDefault())
    calendar.timeInMillis = ts
    return android.text.format.DateFormat.format("dd.MM.yyyy", calendar).toString()
}
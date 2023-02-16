package com.example.arcxpcodechallenge.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun String?.applyDateFormat(
    stringPatternInput: String = "yyyy-MM-dd'T'HH:mm:ss",
    stringPatternOutput: String = "dd MMM yyyy"
): String {
    if (this.isNullOrBlank()) return ""
    val simpleDateFormatInput = SimpleDateFormat(stringPatternInput, Locale.getDefault())
    val simpleDateFormatOutput = SimpleDateFormat(stringPatternOutput, Locale.getDefault())
    return try {
        simpleDateFormatInput.parse(this)?.let {
            simpleDateFormatOutput.format(it)
        }.orEmpty()
    } catch (e: Exception) {
        ""
    }
}

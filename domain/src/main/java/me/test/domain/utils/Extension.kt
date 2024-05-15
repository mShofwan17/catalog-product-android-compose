package me.test.domain.utils

import java.text.NumberFormat
import java.util.Locale

fun Double?.toIdrCurrency(): String {
    return try {
        val nf = NumberFormat.getCurrencyInstance(Locale("ID", "id"))
        nf.format(this).substringBeforeLast(",")
    } catch (e: Exception) {
        "Rp0"
    }
}
package com.veprek.honza.homework.design.presentation.mapper

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

/**
 * Formats a numeric value as currency using Czech locale formatting
 */
fun Double.toFormattedCurrency(currency: String): String {
    val decimalFormat = DecimalFormat("#,##0.00", DecimalFormatSymbols(Locale("cs", "CZ")))
    return "${decimalFormat.format(this)} $currency"
}
package com.manuflowers.moneyconversion.ui.utils

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun String?.formatAmount(
    decimalFormat: String = "#,###,##0.00"
): String {
    val dFormat = DecimalFormat(decimalFormat, DecimalFormatSymbols(Locale.US))
    val value = if (this.isNullOrEmpty()) "0.0" else this
    return dFormat.format(BigDecimal(value))
}
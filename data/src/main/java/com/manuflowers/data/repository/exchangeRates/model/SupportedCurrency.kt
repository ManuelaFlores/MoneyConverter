package com.manuflowers.data.repository.exchangeRates.model

import com.squareup.moshi.Json

data class SupportedCurrency(
    @field:Json(name = "code")
    val currencyCode: String,
    @field:Json(name = "purchase")
    val purchaseValue: Float,
    @field:Json(name = "sale")
    val saleValue: Float,
)
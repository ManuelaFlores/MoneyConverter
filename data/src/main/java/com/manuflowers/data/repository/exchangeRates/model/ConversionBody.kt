package com.manuflowers.data.repository.exchangeRates.model

import com.squareup.moshi.Json

data class ConversionBody(
    @field:Json(name = "base")
    val baseCurrency: String,
    @field:Json(name = "results")
    val supportedCurrencies: List<SupportedCurrency>
)
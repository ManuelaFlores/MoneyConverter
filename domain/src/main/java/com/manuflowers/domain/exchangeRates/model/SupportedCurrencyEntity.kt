package com.manuflowers.domain.exchangeRates.model

data class SupportedCurrencyEntity(
    val currencyCode: CurrencyCode,
    val purchaseValue: Float,
    val saleValue: Float,
)
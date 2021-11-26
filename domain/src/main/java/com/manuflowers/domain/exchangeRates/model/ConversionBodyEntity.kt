package com.manuflowers.domain.exchangeRates.model

data class ConversionBodyEntity(
    val baseCurrencyCode: CurrencyCode,
    val supportedCurrencies: List<SupportedCurrencyEntity>
)
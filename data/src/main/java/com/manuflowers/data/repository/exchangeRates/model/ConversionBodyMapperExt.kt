package com.manuflowers.data.repository.exchangeRates.model

import com.manuflowers.domain.exchangeRates.model.ConversionBodyEntity
import com.manuflowers.domain.exchangeRates.model.CurrencyCode
import com.manuflowers.domain.exchangeRates.model.SupportedCurrencyEntity

fun ConversionBody.toEntity(): ConversionBodyEntity {
    return ConversionBodyEntity(
        baseCurrencyCode = CurrencyCode.valueOf(this.baseCurrency),
        supportedCurrencies = this.supportedCurrencies.map { it.toEntity() }
    )
}

fun SupportedCurrency.toEntity(): SupportedCurrencyEntity {
    return SupportedCurrencyEntity(
        currencyCode = CurrencyCode.valueOf(this.currencyCode),
        purchaseValue = purchaseValue,
        saleValue = saleValue
    )
}
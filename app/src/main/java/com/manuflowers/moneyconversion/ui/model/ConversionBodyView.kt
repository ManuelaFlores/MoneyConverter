package com.manuflowers.moneyconversion.ui.model

import com.manuflowers.domain.exchangeRates.model.CurrencyCode
import com.manuflowers.domain.exchangeRates.model.SupportedCurrencyEntity
import com.manuflowers.moneyconversion.R

data class ConversionBodyView(
    val baseCurrencyCode: CurrencyCode,
    val supportedCurrencies: List<SupportedCurrencyEntity>
) {
    val uri: String
        get() = "drawable/ic_${baseCurrencyCode.name.lowercase()}"

    val currencyName: Int
        get() {
            return when (baseCurrencyCode) {
                CurrencyCode.EUR -> {
                    R.string.union_european_currency_title
                }
                CurrencyCode.USD -> {
                    R.string.united_states_currency_title
                }
                CurrencyCode.JPY -> {
                    R.string.japan_currency_title
                }
                CurrencyCode.GBP -> {
                    R.string.united_kingdom_currency_title
                }
                CurrencyCode.CHF -> {
                    R.string.switzerland_currency_title
                }
                CurrencyCode.CAD -> {
                    R.string.canada_currency_title
                }
            }
        }
}
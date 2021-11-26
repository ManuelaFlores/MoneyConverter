package com.manuflowers.moneyconversion.ui.viewmodel

import com.manuflowers.domain.exchangeRates.model.ConversionBodyEntity
import com.manuflowers.moneyconversion.ui.model.ConversionBodyView

fun ConversionBodyEntity.toView() :ConversionBodyView {
    return ConversionBodyView(
        this.baseCurrencyCode,
        this.supportedCurrencies
    )
}
package com.manuflowers.moneyconversion.ui.screens.conversionCalculator.model

import com.manuflowers.domain.exchangeRates.model.CurrencyCode
import com.manuflowers.moneyconversion.base.BaseViewState

data class ConversionCalculatorState(
    val conversionSellRate: Float = 0.0f,
    val conversionPurchaseRate: Float = 0.0f,
    val senMoneyCurrency: CurrencyCode = CurrencyCode.USD,
    val receiveMoneyCurrency: CurrencyCode = CurrencyCode.EUR,
    val sendMoneyConvertedAmount: String = "",
    val receiveMoneyConverted: String = ""
) : BaseViewState
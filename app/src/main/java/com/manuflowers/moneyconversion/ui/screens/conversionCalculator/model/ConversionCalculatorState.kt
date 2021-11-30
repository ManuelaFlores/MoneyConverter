package com.manuflowers.moneyconversion.ui.screens.conversionCalculator.model

import com.manuflowers.domain.exchangeRates.model.CurrencyCode
import com.manuflowers.moneyconversion.base.BaseViewState
import com.manuflowers.moneyconversion.base.SingleEvent

data class ConversionCalculatorState(
    val conversionSellRate: Float = 0.0f,
    val conversionPurchaseRate: Float = 0.0f,
    val sendMoneyCurrency: CurrencyCode = CurrencyCode.USD,
    val receiveMoneyCurrency: CurrencyCode = CurrencyCode.EUR,
    val sendMoneyConvertedAmount: String = "",
    val receiveMoneyConverted: String = "",
    val currentPurchaseValue: String = "",
    val currentSellValue : String = "",
    val shouldUpdateReceiveValue: SingleEvent<Boolean> = SingleEvent(false)
) : BaseViewState
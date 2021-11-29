package com.manuflowers.moneyconversion.ui.model

import com.manuflowers.domain.exchangeRates.model.CurrencyCode
import com.manuflowers.moneyconversion.base.BaseViewState
import com.manuflowers.moneyconversion.base.SingleEvent

data class MainViewState(
    val isLoading: Boolean = false,
    val currenciesList: SingleEvent<List<ConversionBodyView>> = SingleEvent(listOf()),
    val isValueFromSendMoney: Boolean? = null,
    val newCurrencySelected: SingleEvent<CurrencyCode> = SingleEvent(CurrencyCode.USD),
    val isValueFromSendMoneyLabel: Boolean? = false
) : BaseViewState
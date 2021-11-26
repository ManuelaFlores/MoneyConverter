package com.manuflowers.moneyconversion.ui.model

import android.text.BoringLayout
import com.manuflowers.domain.exchangeRates.model.CurrencyCode
import com.manuflowers.moneyconversion.base.BaseViewState
import com.manuflowers.moneyconversion.base.SingleEvent

data class MainViewState(
    val isLoading: Boolean = false,
    val currenciesList: SingleEvent<List<ConversionBodyView>> = SingleEvent(listOf()),
    val isValueFromSendMoney: Boolean? = null,
    val newCurrencySelected: SingleEvent<CurrencyCode>? = null,
    val isValueFromSendMoneyLabel: Boolean? = false
) : BaseViewState
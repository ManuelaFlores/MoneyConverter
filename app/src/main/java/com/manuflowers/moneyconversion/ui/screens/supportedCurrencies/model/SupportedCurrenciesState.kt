package com.manuflowers.moneyconversion.ui.screens.supportedCurrencies.model

import com.manuflowers.domain.exchangeRates.model.SupportedCurrencyEntity
import com.manuflowers.moneyconversion.base.BaseViewState
import com.manuflowers.moneyconversion.base.SingleEvent

data class SupportedCurrenciesState(
    val currenciesList: SingleEvent<List<SupportedCurrencyEntity>> = SingleEvent(listOf())
) : BaseViewState
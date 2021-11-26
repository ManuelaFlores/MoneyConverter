package com.manuflowers.moneyconversion.ui.screens.supportedCurrencies.viewmodel

import com.manuflowers.domain.exchangeRates.GetExchangeRatesUseCase
import com.manuflowers.moneyconversion.base.BaseViewModel
import com.manuflowers.moneyconversion.ui.screens.supportedCurrencies.model.SupportedCurrenciesState

class SupportedCurrenciesViewModel(
    private val getExchangeRatesUseCase: GetExchangeRatesUseCase
): BaseViewModel<SupportedCurrenciesState>() {

    override val initialState: SupportedCurrenciesState = SupportedCurrenciesState()

    init {
        viewState.value = initialState
    }


}
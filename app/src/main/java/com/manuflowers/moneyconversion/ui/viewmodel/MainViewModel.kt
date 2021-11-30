package com.manuflowers.moneyconversion.ui.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.manuflowers.domain.exchangeRates.GetExchangeRatesUseCase
import com.manuflowers.domain.exchangeRates.model.CurrencyCode
import com.manuflowers.domain.utils.Error
import com.manuflowers.domain.utils.Success
import com.manuflowers.moneyconversion.base.BaseViewModel
import com.manuflowers.moneyconversion.base.SingleEvent
import com.manuflowers.moneyconversion.ui.model.MainViewState
import com.manuflowers.moneyconversion.ui.utils.formatAmount
import kotlinx.coroutines.launch

class MainViewModel(
    private val getExchangeRatesUseCase: GetExchangeRatesUseCase
) : BaseViewModel<MainViewState>() {

    override val initialState = MainViewState()

    init {
        viewState.value = initialState
    }

    fun getExchangeRates() {
        viewModelScope.launch {
            /*state = state.copy(
                isLoading = true
            )*/
            when (val result = getExchangeRatesUseCase.getExchangeRates()) {
                is Success -> {
                    state = state.copy(
                        currenciesList = SingleEvent(result.data.map { entity ->
                            entity.toView()
                        }),
                    )
                }
                is Error -> {

                }
            }
        }
    }

    fun setNewCurrency(currency: CurrencyCode) {
        state = state.copy(newCurrencySelected = SingleEvent(currency))
    }

   /* fun setPurchaseAndSellValues(purchaseValue: Float, sellValue: Float) {
        state = state.copy(
            currentPurchaseValue = purchaseValue.toString().formatAmount(),
            currentSellValue = sellValue.toString().formatAmount()
        )
    }*/

    fun setOriginValue(isValueFromSendMoneyLabel: Boolean) {
        state = state.copy(
            isValueFromSendMoney = isValueFromSendMoneyLabel
        )
    }
}
package com.manuflowers.moneyconversion.ui.screens.conversionCalculator.viewmodel

import android.util.Log
import com.manuflowers.domain.exchangeRates.model.CurrencyCode
import com.manuflowers.moneyconversion.R
import com.manuflowers.moneyconversion.base.BaseViewModel
import com.manuflowers.moneyconversion.ui.model.ConversionBodyView
import com.manuflowers.moneyconversion.ui.screens.conversionCalculator.model.ConversionCalculatorState
import com.manuflowers.moneyconversion.ui.utils.formatAmount

class ConversionCalculatorViewModel : BaseViewModel<ConversionCalculatorState>() {

    override val initialState = ConversionCalculatorState()

    init {
        viewState.value = initialState
    }



    fun validateReceiveMoney(moneyText: String, currenciesList: List<ConversionBodyView>) {
        try {
            val inputMoney = moneyText.replace(",", "").toFloatOrNull() ?: 0.0f

            val selectedConversionBodyView = currenciesList.find {
                state.receiveMoneyCurrency == it.baseCurrencyCode
            }

            val moneyToChange = selectedConversionBodyView?.let {
                it.supportedCurrencies.find { supportedCurrency ->
                    state.senMoneyCurrency == supportedCurrency.currencyCode
                }
            }
            Log.e("MONEY TO CHANGE", "-----${moneyToChange}")

            moneyToChange?.let {
                val result = inputMoney * it.purchaseValue
                state = state.copy(
                    sendMoneyConvertedAmount = result.toString().formatAmount()
                )
                Log.e("MONEY RESULT----", "-----${result}")
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun validateSentMoney(moneyText: String, currenciesList: List<ConversionBodyView>) {
        try {
            val inputMoney = moneyText.replace(",", "").toFloatOrNull() ?: 0.0f

            val selectedConversionBodyView = currenciesList.find {
                state.senMoneyCurrency == it.baseCurrencyCode
            }

            val moneyToChange = selectedConversionBodyView?.let {
                it.supportedCurrencies.find { supportedCurrency ->
                    state.receiveMoneyCurrency == supportedCurrency.currencyCode
                }
            }
            Log.e("MONEY TO CHANGE", "-----${moneyToChange}")

            moneyToChange?.let {
                val result = inputMoney * it.purchaseValue
                state = state.copy(
                    receiveMoneyConverted = result.toString().formatAmount()
                )
                Log.e("MONEY RESULT----", "-----${result}")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getLabel(currency: CurrencyCode): Int {
        return when (currency) {
            CurrencyCode.EUR -> {
                R.string.union_european_currency_label
            }
            CurrencyCode.USD -> {
                R.string.united_states_currency_label
            }
            CurrencyCode.JPY -> {
                R.string.japan_currency_label
            }
            CurrencyCode.GBP -> {
                R.string.united_kingdom_currency_label
            }
            CurrencyCode.CHF -> {
                R.string.switzerland_currency_label
            }
            CurrencyCode.CAD -> {
                R.string.canada_currency_label
            }
        }
    }

    fun changeCurrencyOfSendMoney(
        currency: CurrencyCode,
        isValueFromSendMoney: Boolean
    ) {
        state = if (isValueFromSendMoney) {
            state.copy(
                senMoneyCurrency = currency
            )
        } else {
            state.copy(
                receiveMoneyCurrency = currency
            )
        }
    }

    fun changeReceiveMoneyCurrency(currencyCode: CurrencyCode) {

    }
}
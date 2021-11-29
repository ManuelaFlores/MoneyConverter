package com.manuflowers.moneyconversion.ui.screens.supportedCurrencies.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manuflowers.domain.exchangeRates.model.CurrencyCode
import com.manuflowers.moneyconversion.R
import com.manuflowers.moneyconversion.ui.model.ConversionBodyView
import kotlinx.android.synthetic.main.item_supported_currency.view.*

class SupportedCurrenciesViewHolder private constructor(
    view: View
) : RecyclerView.ViewHolder(view) {
    companion object {
        fun newInstance(parent: ViewGroup): SupportedCurrenciesViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_supported_currency, parent, false)
            return SupportedCurrenciesViewHolder(view)
        }
    }

    fun bind(
        conversionBodyView: ConversionBodyView,
        onClickListener: (currencyCode: CurrencyCode) -> Unit,
        currentCurrencyCode: CurrencyCode
    ) {
        val context = itemView.context
        itemView.setOnClickListener {
            onClickListener(conversionBodyView.baseCurrencyCode)
        }
        val imageResource =
            context.resources.getIdentifier(conversionBodyView.uri, null, context.packageName)
        itemView.imageViewFlagCurrency.setImageResource(imageResource)
        itemView.textViewCountryCurrency.text =
            itemView.context.getString(conversionBodyView.currencyName)

        val exchangeView = conversionBodyView.supportedCurrencies.find { currentCurrencyCode == it.currencyCode }

        val defaultExchange = "1 ${currentCurrencyCode}"
        val normalExchange = "${exchangeView?.purchaseValue} ${currentCurrencyCode}"

        itemView.textViewExchange.text =
            "1 ${conversionBodyView.baseCurrencyCode} = ${ if (exchangeView != null) normalExchange  else defaultExchange}"

    }
}
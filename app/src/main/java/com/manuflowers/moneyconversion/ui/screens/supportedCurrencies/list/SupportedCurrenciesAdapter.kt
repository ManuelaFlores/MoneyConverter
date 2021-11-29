package com.manuflowers.moneyconversion.ui.screens.supportedCurrencies.list

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manuflowers.domain.exchangeRates.model.CurrencyCode
import com.manuflowers.moneyconversion.ui.model.ConversionBodyView

class SupportedCurrenciesAdapter(
    private val onCLickListener: (currencyCode: CurrencyCode) -> Unit,
    private val currentCurrencyCode: CurrencyCode,
) : RecyclerView.Adapter<SupportedCurrenciesViewHolder>() {

    private val data: MutableList<ConversionBodyView> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SupportedCurrenciesViewHolder {
        return SupportedCurrenciesViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: SupportedCurrenciesViewHolder, position: Int) {
        holder.bind(data[position], onCLickListener, currentCurrencyCode)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addData(data: List<ConversionBodyView>) {
        if (this.data.isNotEmpty()) {
            this.data.clear()
            this.data.addAll(data)
        } else {
            val newList = data.filterNot { currentCurrencyCode == it.baseCurrencyCode }
            this.data.addAll(data)
        }
        notifyDataSetChanged()
    }
}
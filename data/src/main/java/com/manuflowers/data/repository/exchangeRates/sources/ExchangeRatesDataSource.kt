package com.manuflowers.data.repository.exchangeRates.sources

import com.manuflowers.data.repository.exchangeRates.model.ConversionBody
import com.manuflowers.domain.utils.Result

interface ExchangeRatesDataSource {
    fun getAssetsData() : Result<List<ConversionBody>>
}
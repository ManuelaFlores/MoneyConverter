package com.manuflowers.domain.exchangeRates.repository

import com.manuflowers.domain.exchangeRates.model.ConversionBodyEntity
import com.manuflowers.domain.utils.Result

interface ExchangeRatesRepository {
     fun getExchangeRates() : Result<List<ConversionBodyEntity>>
}
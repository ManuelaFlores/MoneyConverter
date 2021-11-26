package com.manuflowers.domain.exchangeRates

import com.manuflowers.domain.exchangeRates.model.ConversionBodyEntity
import com.manuflowers.domain.exchangeRates.repository.ExchangeRatesRepository
import com.manuflowers.domain.utils.Result

class GetExchangeRatesUseCase(
    private val exchangeRatesRepository: ExchangeRatesRepository
) {
    fun getExchangeRates(): Result<List<ConversionBodyEntity>> {
        return exchangeRatesRepository.getExchangeRates()
    }
}
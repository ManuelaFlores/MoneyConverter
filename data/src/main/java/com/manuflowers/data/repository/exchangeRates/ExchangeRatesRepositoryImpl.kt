package com.manuflowers.data.repository.exchangeRates

import com.manuflowers.data.repository.exchangeRates.model.toEntity
import com.manuflowers.data.repository.exchangeRates.sources.ExchangeRatesDataSource
import com.manuflowers.domain.exchangeRates.model.ConversionBodyEntity
import com.manuflowers.domain.exchangeRates.repository.ExchangeRatesRepository
import com.manuflowers.domain.utils.Error
import com.manuflowers.domain.utils.Result
import com.manuflowers.domain.utils.Success

class ExchangeRatesRepositoryImpl(private val exchangeRatesDataSource: ExchangeRatesDataSource) :
    ExchangeRatesRepository {
    override fun getExchangeRates(): Result<List<ConversionBodyEntity>> {
        return when (val result = exchangeRatesDataSource.getAssetsData()) {
            is Success -> {
                Success(result.data.map { it.toEntity() })
            }
            is Error -> {
                Error()
            }
        }
    }

}
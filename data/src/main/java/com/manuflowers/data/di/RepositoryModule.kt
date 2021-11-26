package com.manuflowers.data.di

import com.manuflowers.data.repository.exchangeRates.ExchangeRatesRepositoryImpl
import com.manuflowers.data.repository.exchangeRates.sources.ExchangeRatesDataSource
import com.manuflowers.data.repository.exchangeRates.sources.local.ExchangeRatesDataSourceImpl
import com.manuflowers.domain.exchangeRates.repository.ExchangeRatesRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single<ExchangeRatesDataSource> { ExchangeRatesDataSourceImpl(androidContext()) }
    single<ExchangeRatesRepository> { ExchangeRatesRepositoryImpl(get()) }
}
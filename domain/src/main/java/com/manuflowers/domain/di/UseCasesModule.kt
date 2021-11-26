package com.manuflowers.domain.di

import com.manuflowers.domain.exchangeRates.GetExchangeRatesUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory { GetExchangeRatesUseCase(get()) }
}
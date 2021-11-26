package com.manuflowers.moneyconversion.di

import com.manuflowers.moneyconversion.ui.screens.conversionCalculator.viewmodel.ConversionCalculatorViewModel
import com.manuflowers.moneyconversion.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { ConversionCalculatorViewModel() }

    viewModel { MainViewModel(get()) }
}
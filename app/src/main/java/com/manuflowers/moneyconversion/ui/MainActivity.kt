package com.manuflowers.moneyconversion.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manuflowers.moneyconversion.R
import com.manuflowers.moneyconversion.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.getExchangeRates()
    }
}
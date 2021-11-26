package com.manuflowers.moneyconversion.ui.screens.supportedCurrencies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.manuflowers.moneyconversion.R
import com.manuflowers.moneyconversion.ui.model.MainViewState
import com.manuflowers.moneyconversion.ui.screens.supportedCurrencies.list.SupportedCurrenciesAdapter
import com.manuflowers.moneyconversion.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_supported_currencies.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SupportedCurrenciesFragment : Fragment() {

    private val mainViewModel: MainViewModel by sharedViewModel()

    private val supportedCurrenciesAdapter = SupportedCurrenciesAdapter {
        mainViewModel.setNewCurrency(it)
        findNavController().popBackStack()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_supported_currencies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeSharedState(::onSharedStateChange)
    }

    private fun setupViews() {
        recyclerViewSupportedCurrencies.adapter = supportedCurrenciesAdapter
        supportedCurrenciesAdapter.addData(mainViewModel.state.currenciesList.peek())
    }

    private fun observeSharedState(onSharedStateChanged: (sharedState: MainViewState) -> Unit) {
        val observer = Observer<MainViewState> { mainViewState ->
            onSharedStateChanged.invoke(mainViewState)
        }
        mainViewModel.viewState.observe(viewLifecycleOwner, observer)
    }

    private fun onSharedStateChange(mainViewState: MainViewState) {

    }
}
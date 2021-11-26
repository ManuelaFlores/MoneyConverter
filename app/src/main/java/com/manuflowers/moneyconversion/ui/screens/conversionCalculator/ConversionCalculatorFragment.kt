package com.manuflowers.moneyconversion.ui.screens.conversionCalculator

import android.os.Bundle
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.manuflowers.moneyconversion.R
import com.manuflowers.moneyconversion.ui.model.MainViewState
import com.manuflowers.moneyconversion.ui.screens.conversionCalculator.model.ConversionCalculatorState
import com.manuflowers.moneyconversion.ui.screens.conversionCalculator.viewmodel.ConversionCalculatorViewModel
import com.manuflowers.moneyconversion.ui.utils.MoneyTextWatcher
import com.manuflowers.moneyconversion.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_conversion_calculator.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ConversionCalculatorFragment : Fragment() {

    private val viewModel: ConversionCalculatorViewModel by inject()
    private val mainViewModel: MainViewModel by sharedViewModel()

    private lateinit var onAmountSendMoneyWatcher: TextWatcher
    private lateinit var onAmountReceiveMoneyWatcher: TextWatcher

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_conversion_calculator, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeSate(::onStateChanged)
        observeSharedState(::onSharedStateChange)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        onAmountReceiveMoneyWatcher = object : MoneyTextWatcher(editTextReceiveMoneyAmount) {
            override fun updateText(editText: EditText, formatted: String) {
                viewModel.validateReceiveMoney(formatted, mainViewModel.state.currenciesList.peek())
                super.updateText(editText, formatted)
                editTextSendMoneyAmount.setText(viewModel.state.sendMoneyConvertedAmount)
            }
        }

        onAmountSendMoneyWatcher = object : MoneyTextWatcher(editTextSendMoneyAmount) {
            override fun updateText(editText: EditText, formatted: String) {
                viewModel.validateSentMoney(formatted, mainViewModel.state.currenciesList.peek())
                super.updateText(editText, formatted)
                editTextReceiveMoneyAmount.setText(viewModel.state.receiveMoneyConverted)
            }
        }

        editTextReceiveMoneyAmount.onFocusChangeListener = View.OnFocusChangeListener { view, _ ->
            if (view.hasFocus()) {
                editTextReceiveMoneyAmount.addTextChangedListener(onAmountReceiveMoneyWatcher)
                editTextSendMoneyAmount.removeTextChangedListener(onAmountSendMoneyWatcher)
            }
        }

        editTextSendMoneyAmount.onFocusChangeListener = View.OnFocusChangeListener { view, _ ->
            if (view.hasFocus()) {
                editTextSendMoneyAmount.addTextChangedListener(onAmountSendMoneyWatcher)
                editTextReceiveMoneyAmount.removeTextChangedListener(onAmountReceiveMoneyWatcher)
            }
        }
        textViewSendMoneyLabel.text = getString(viewModel.getLabel(viewModel.state.senMoneyCurrency))
        textViewReceiveMoneyLabel.text = getString(viewModel.getLabel(viewModel.state.receiveMoneyCurrency))
    }

    private fun setupListeners() {
        textViewSendMoneyLabel.setOnLongClickListener {
            mainViewModel.setOriginValue(isValueFromSendMoneyLabel = true)
            findNavController().navigate(R.id.action_conversionCalculator_to_supportedCurrenciesFragment)
            true
        }
    }

    private fun observeSate(onStateChanged: (mainViewState: ConversionCalculatorState) -> Unit) {
        val observer = Observer<ConversionCalculatorState> { viewState ->
            onStateChanged.invoke(viewState)
        }
        viewModel.viewState.observe(viewLifecycleOwner, observer)
        observer.onChanged(viewModel.state)
    }

    private fun observeSharedState(onSharedStateChanged: (sharedState: MainViewState) -> Unit) {
        val observer = Observer<MainViewState> { mainViewState ->
            onSharedStateChanged.invoke(mainViewState)
        }
        mainViewModel.viewState.observe(viewLifecycleOwner, observer)
    }

    private fun onStateChanged(conversionCalculatorState: ConversionCalculatorState) {
    }

    private fun onSharedStateChange(mainViewState: MainViewState) {
        mainViewState.currenciesList.consume()?.let {
        }
        mainViewState.newCurrencySelected?.consume()?.let {
            mainViewModel.state.isValueFromSendMoney?.let { isValueFromSendMoney ->
                viewModel.changeCurrencyOfSendMoney(it, isValueFromSendMoney)
                if (isValueFromSendMoney) {
                    textViewSendMoneyLabel.text = getString(viewModel.getLabel(it))
                } else {
                    textViewReceiveMoneyLabel.text = getString(viewModel.getLabel(it))
                    editTextReceiveMoneyAmount.setText(viewModel.state.receiveMoneyConverted)
                }
            }
        }
    }
}
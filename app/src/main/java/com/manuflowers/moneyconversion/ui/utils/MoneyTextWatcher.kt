package com.manuflowers.moneyconversion.ui.utils

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference
import java.util.*
import kotlin.coroutines.CoroutineContext

open class MoneyTextWatcher(
    editText: EditText,
    private val before: () -> Unit = {},
    private val after: (Editable?) -> Unit = {}
) : TextWatcher, CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    private lateinit var moneyTextJob: Job

    private val editTextWeakReference: WeakReference<EditText> = WeakReference(editText)

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        if (::moneyTextJob.isInitialized) {
            moneyTextJob.cancel()
        }
        moneyTextJob = launch(Dispatchers.IO) {
            before.invoke()
        }
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(editable: Editable?) {
        val editText = editTextWeakReference.get() ?: return

        if (::moneyTextJob.isInitialized) {
            moneyTextJob.cancel()
        }
        val s = editable.toString()
        if (s.isNullOrEmpty()) return

        moneyTextJob = launch(Dispatchers.IO) {
            try {
                val formatted = s.formatTextFromEditable()
                launch(Dispatchers.Main) {
                    editText.removeTextChangedListener(this@MoneyTextWatcher)
                    updateText(editText, formatted)
                    editText.addTextChangedListener(this@MoneyTextWatcher)
                    after.invoke(editable)
                }
            } catch (e: Exception) {
                Log.e("EXCEPTION", "${e.localizedMessage}")
            }
        }
    }

    open fun updateText(editText: EditText, formatted: String) {
        editText.setText(formatted)
        editText.setSelection(formatted.length)
    }
}
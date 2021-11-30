package com.manuflowers.moneyconversion.utils

import com.manuflowers.moneyconversion.ui.utils.formatAmount
import com.manuflowers.moneyconversion.ui.utils.formatTextFromEditable
import org.junit.Test

class ExtensionsTest {
    @Test
    fun formatAmount() {
        val result = "123456".formatAmount()
        println(result)
        assert(result == "123,456.00")
    }

    @Test
    fun formatTextFromEditable() {
        val result = "1,00".formatTextFromEditable()
        println(result)
        assert(result == "1.00")
    }
}
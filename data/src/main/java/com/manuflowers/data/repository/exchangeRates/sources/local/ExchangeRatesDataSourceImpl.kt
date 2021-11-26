package com.manuflowers.data.repository.exchangeRates.sources.local

import android.content.Context
import android.util.Log
import com.manuflowers.data.repository.exchangeRates.model.ConversionBody
import com.manuflowers.data.repository.exchangeRates.sources.ExchangeRatesDataSource
import com.manuflowers.domain.utils.Error
import com.manuflowers.domain.utils.Result
import com.manuflowers.domain.utils.Success
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.io.IOException

class ExchangeRatesDataSourceImpl(private val context: Context) : ExchangeRatesDataSource {
    override fun getAssetsData(): Result<List<ConversionBody>> {
        val moshi = Moshi.Builder().build()
        val conversionBodyType =
            Types.newParameterizedType(List::class.java, ConversionBody::class.java)
        val adapter = moshi.adapter<List<ConversionBody>>(conversionBodyType)
        val jsonString: String
        return try {
            jsonString = context.assets.open("data.json").bufferedReader().use {
                it.readText()
            }
            val parsedData = adapter.fromJson(jsonString)
            Log.e("AAAAAAAAA", "${adapter.fromJson(jsonString)}")
            if (!parsedData.isNullOrEmpty()) {
                Success(parsedData)
            } else {
                Error()
            }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            Error()
        }
    }
}
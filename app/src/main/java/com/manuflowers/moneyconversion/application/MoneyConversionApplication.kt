package com.manuflowers.moneyconversion.application

import android.app.Application
import com.manuflowers.data.di.repositoryModule
import com.manuflowers.domain.di.useCasesModule
import com.manuflowers.moneyconversion.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MoneyConversionApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MoneyConversionApplication)
            if (BuildConfig.DEBUG) androidLogger(Level.DEBUG)
            modules(dataModules + domainModules + presentationModule)
        }
    }
}

val presentationModule = listOf(com.manuflowers.moneyconversion.di.presentationModule)
val dataModules = listOf(repositoryModule)
val domainModules = listOf(useCasesModule)
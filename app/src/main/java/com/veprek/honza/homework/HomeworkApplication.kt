package com.veprek.honza.homework

import android.app.Application
import com.veprek.honza.homework.core.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HomeworkApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HomeworkApplication)
            modules(appModules)
        }
    }
}
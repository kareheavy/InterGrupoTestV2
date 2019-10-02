package com.jhonjimenez.intergrupotestv2.presentation

import android.app.Application
import com.jhonjimenez.intergrupotestv2.presentation.di.Module

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class InterGrupoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@InterGrupoApp)
            modules(listOf(Module.signInModule, Module.networkModule, Module.sharedPreferencesModule))
        }
    }
}
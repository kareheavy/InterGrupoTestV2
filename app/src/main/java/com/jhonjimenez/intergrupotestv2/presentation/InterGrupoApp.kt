package com.jhonjimenez.intergrupotestv2.presentation

import android.app.Application

class InterGrupoApp : Application() {

    companion object {
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}
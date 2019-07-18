package com.jhonjimenez.intergrupotestv2

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context){

    companion object{
        val IS_NIGHT_MODE = "IsNightMode"
    }

    val PREFS_NAME = "com.jhonjimenez.intergrupotestv2"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    fun getBoolean(prefsName: String) = prefs.getBoolean(prefsName, false)
    fun setBoolean(prefsName: String, value: Boolean) = prefs.edit().putBoolean(prefsName, value).apply()
}
package com.jhonjimenez.intergrupotestv2.presentation

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context){

    companion object{
        const val REMENBER_ME = "remenber_me"
        const val EMAIL = "email"
        const val PASSWORD = "password"
        const val PREFS_NAME = "com.jhonjimenez.intergrupotestv2"
    }

    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    fun getBoolean(prefsName: String) = prefs.getBoolean(prefsName, false)
    fun setBoolean(prefsName: String, value: Boolean) = prefs.edit().putBoolean(prefsName, value).apply()

    fun getString(prefsName: String) = prefs.getString(prefsName, "")
    fun setString(prefsName: String, value: String) = prefs.edit().putString(prefsName, value).apply()
}
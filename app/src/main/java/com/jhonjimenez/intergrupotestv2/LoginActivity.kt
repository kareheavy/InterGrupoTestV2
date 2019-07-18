package com.jhonjimenez.intergrupotestv2

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDarkMode(window)

        buttonSendOtp.setOnClickListener(){

            if(!InterGrupoApp.prefs.getBoolean(Prefs.IS_NIGHT_MODE))
                InterGrupoApp.prefs.setBoolean(Prefs.IS_NIGHT_MODE, true)
            else
                InterGrupoApp.prefs.setBoolean(Prefs.IS_NIGHT_MODE, false)

            setDarkMode(window)
        }
    }

    fun setDarkMode(window: Window) {
        if (InterGrupoApp.prefs.getBoolean(Prefs.IS_NIGHT_MODE)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            changeStatusBar(0, window)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            changeStatusBar(1, window)
        }
    }

    fun changeStatusBar(mode: Int, window: Window) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.statusBarColor = resources.getColor(R.color.contentBodyColor);
            //white mode
            if (mode == 1) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
    }
}

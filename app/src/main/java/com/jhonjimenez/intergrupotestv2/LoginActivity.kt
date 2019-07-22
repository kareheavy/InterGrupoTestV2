package com.jhonjimenez.intergrupotestv2

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jhonjimenez.intergrupotestv2.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*
import timber.log.Timber

class LoginActivity : AppCompatActivity() {

    lateinit var viewModel: LoginViewModel
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)//Asociamos la UI con el binding
        binding.lifecycleOwner = this//Para que el binding sea conciente de del ciclo de vida
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)//Llamamos al viewmodel
        binding.loginViewModel = viewModel//Asociamos el viewmodel con el binding

        viewModel.username.observe(this, Observer {

        })

        viewModel.password.observe(this, Observer {

        })

        setDarkMode()

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.elevation = 0F

        buttonSendOtp.setOnClickListener {

            if (!InterGrupoApp.prefs.getBoolean(Prefs.IS_NIGHT_MODE))
                InterGrupoApp.prefs.setBoolean(Prefs.IS_NIGHT_MODE, true)
            else
                InterGrupoApp.prefs.setBoolean(Prefs.IS_NIGHT_MODE, false)

            setDarkMode()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.dark_mode_menu, menu)
        return true
    }

    fun setDarkMode() {
        if (InterGrupoApp.prefs.getBoolean(Prefs.IS_NIGHT_MODE)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}

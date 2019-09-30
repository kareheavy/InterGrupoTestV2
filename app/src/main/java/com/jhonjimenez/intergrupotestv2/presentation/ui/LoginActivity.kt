package com.jhonjimenez.intergrupotestv2.presentation.ui

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.jhonjimenez.intergrupotestv2.R
import com.jhonjimenez.intergrupotestv2.databinding.ActivityLoginBinding
import timber.log.Timber

class LoginActivity : AppCompatActivity() {

    lateinit var viewModel: LoginViewModel
    lateinit var viewModelFactory: LoginViewModelFactory
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)//Asociamos la UI con el binding
        binding = ActivityLoginBinding.inflate(layoutInflater)//Esto creo que se llama viewbinding
        setContentView(binding.root)

        setupViewModel()
        setupClickListener()
        setupObservers()

        viewModel.getCredentials()

    }

    private fun setupViewModel() {

        viewModelFactory = LoginViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(LoginViewModel::class.java)//Llamamos al viewmodel
        binding.lifecycleOwner = this//Para que el binding sea conciente de del ciclo de vida
        binding.loginViewModel = viewModel//Asociamos el viewmodel con el binding
    }

    private fun setupClickListener() {
        binding.buttonSignIn.setOnClickListener {
            doLogin()
        }

        binding.editTextPassword.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) doLogin()

            return@setOnEditorActionListener true
        }
    }

    private fun doLogin() {
        viewModel.doLogin(
            binding.editTextEmail.text.toString(),
            binding.editTextPassword.text.toString(),
            binding.checkBoxRemenberMe.isChecked
        )
    }

    private fun setupObservers() {
        viewModel.message.observe(this,
            Observer { message ->
                Snackbar.make(binding.mainLayout, message, Snackbar.LENGTH_LONG).show()
            }
        )
    }

}

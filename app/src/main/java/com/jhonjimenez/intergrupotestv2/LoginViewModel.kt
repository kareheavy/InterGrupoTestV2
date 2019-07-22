package com.jhonjimenez.intergrupotestv2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class LoginViewModel : ViewModel() {

    private val _username = MutableLiveData<String>()
    val username: LiveData<String>
        get() = _username

    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    private val _progressbar = MutableLiveData<Boolean>()
    val progressbar: LiveData<Boolean>
        get() = _progressbar

    init {
        _progressbar.value = false
        Timber.i("Viewmodel created")
    }

    fun doLogin() {
        _progressbar.value = true
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("Viewmodel destroyed")
    }
}
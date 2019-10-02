package com.jhonjimenez.intergrupotestv2.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jhonjimenez.intergrupotestv2.domain.entities.Result
import com.jhonjimenez.intergrupotestv2.domain.entities.SignInRequest
import com.jhonjimenez.intergrupotestv2.domain.entities.SignInResponse
import com.jhonjimenez.intergrupotestv2.domain.use_cases.SignInUseCase
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SignInViewModel(private val signInUseCase: SignInUseCase) : ViewModel(), CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private val _emailError = MutableLiveData<String>()
    val emailError: LiveData<String>
        get() = _emailError

    private val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email

    private val _passwordError = MutableLiveData<String>()
    val passwordError: LiveData<String>
        get() = _passwordError

    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    private val _isChecked = MutableLiveData<Boolean>()
    val isChecked: LiveData<Boolean>
        get() = _isChecked

    private val _isVisible = MutableLiveData<Boolean>()
    val isVisible: LiveData<Boolean>
        get() = _isVisible

    private val _isEnabled = MutableLiveData<Boolean>()
    val isEnabled: LiveData<Boolean>
        get() = _isEnabled

    private val _message = MutableLiveData<String>()
    val message: LiveData<String>
        get() = _message

    init {
        _isEnabled.value = true
        _isVisible.value = false
    }

    fun getCredentials() {
        launch(Dispatchers.Main) {
            val response = withContext(Dispatchers.IO) {
                signInUseCase.getCredentials()
            }

            if (response is Result.Success<SignInRequest>) {
                _isChecked.value = true
                _email.value = response.data.email
                _password.value = response.data.password
            }

        }
    }

    fun doLogin(email: String, password: String, remenberMe: Boolean) {
        _isEnabled.value = false
        _isVisible.value = true

        val signInRequest = SignInRequest(email, password)

        launch(Dispatchers.Main) {
            val response = withContext(Dispatchers.IO) {
                signInUseCase.signIn(signInRequest, remenberMe)
            }

            _isEnabled.value = true
            _isVisible.value = false

            when (response) {
                is Result.Success<SignInResponse> -> _message.value = "Login Hpta!!!"
                is Result.ErrorUseCase -> setError(response)
                is Result.ErrorRepository -> setError(response)
            }
        }
    }

    private fun <T> setError(response: Result<T>) {

        if (response is Result.ErrorUseCase) {

            _emailError.value = null
            _passwordError.value = null

            response.errors.run {
                if (containsKey("email")) _emailError.value = this["email"]
                if (containsKey("password")) _passwordError.value = this["password"]
            }

        }

        if (response is Result.ErrorRepository) {
            _message.value = response.error.error
        }

    }

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }
}

//class LoginViewModelFactory : ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        @Suppress("UNCHECKED_CAST")
//        return SignInViewModel(Injector().provideSignInUsesCase()) as T
//    }
//
//}
package com.jhonjimenez.intergrupotestv2.data.data_source.local

import com.jhonjimenez.intergrupotestv2.domain.entities.Error
import com.jhonjimenez.intergrupotestv2.domain.entities.Result
import com.jhonjimenez.intergrupotestv2.domain.entities.SignInRequest
import com.jhonjimenez.intergrupotestv2.presentation.InterGrupoApp
import com.jhonjimenez.intergrupotestv2.presentation.Prefs

class SignInLocalSourceImpl(private val prefs: Prefs) : SignInLocalSource {

    override fun saveCredentials(signInRequest: SignInRequest) {
        prefs.setString(Prefs.EMAIL, signInRequest.email)
        prefs.setString(Prefs.PASSWORD, signInRequest.password)
        prefs.setBoolean(Prefs.REMENBER_ME, true)
    }

    override fun getCredentials(): Result<SignInRequest> {
        val remenberMe = prefs.getBoolean(Prefs.REMENBER_ME)
        val email = prefs.getString(Prefs.EMAIL)
        val password = prefs.getString(Prefs.PASSWORD)

        return if (remenberMe) {
            Result.Success(
                SignInRequest(email!!, password!!)
            )
        } else {
            Result.ErrorRepository(Error(0, "Sin credenciales"))
        }
    }

}
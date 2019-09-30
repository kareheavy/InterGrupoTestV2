package com.jhonjimenez.intergrupotestv2.data.data_source.local

import com.jhonjimenez.intergrupotestv2.domain.entities.Error
import com.jhonjimenez.intergrupotestv2.domain.entities.Result
import com.jhonjimenez.intergrupotestv2.domain.entities.SignInRequest
import com.jhonjimenez.intergrupotestv2.presentation.InterGrupoApp
import com.jhonjimenez.intergrupotestv2.presentation.Prefs

class SignInLocalSourceImpl : SignInLocalSource {

    override fun saveCredentials(signInRequest: SignInRequest) {
        InterGrupoApp.prefs.setString(Prefs.EMAIL, signInRequest.email)
        InterGrupoApp.prefs.setString(Prefs.PASSWORD, signInRequest.password)
        InterGrupoApp.prefs.setBoolean(Prefs.REMENBER_ME, true)
    }

    override fun getCredentials(): Result<SignInRequest> {
        val remenberMe = InterGrupoApp.prefs.getBoolean(Prefs.REMENBER_ME)
        val email = InterGrupoApp.prefs.getString(Prefs.EMAIL)
        val password = InterGrupoApp.prefs.getString(Prefs.PASSWORD)

        return if (remenberMe) {
            Result.Success(
                SignInRequest(email!!, password!!)
            )
        } else {
            Result.ErrorRepository(Error(0,"Sin credenciales"))
        }
    }

}
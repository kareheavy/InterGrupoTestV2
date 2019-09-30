package com.jhonjimenez.intergrupotestv2.data.data_source.local

import com.jhonjimenez.intergrupotestv2.domain.entities.Result
import com.jhonjimenez.intergrupotestv2.domain.entities.SignInRequest

interface SignInLocalSource {
    fun saveCredentials(signInRequest: SignInRequest)
    fun getCredentials(): Result<SignInRequest>
}
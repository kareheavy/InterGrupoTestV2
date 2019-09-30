package com.jhonjimenez.intergrupotestv2.domain.use_cases

import com.jhonjimenez.intergrupotestv2.domain.entities.Result
import com.jhonjimenez.intergrupotestv2.domain.entities.SignInRequest
import com.jhonjimenez.intergrupotestv2.domain.entities.SignInResponse

interface SignInUseCase {
    suspend fun signIn(signInRequest: SignInRequest, remenberMe: Boolean): Result<SignInResponse>
    suspend fun getCredentials(): Result<SignInRequest>
}
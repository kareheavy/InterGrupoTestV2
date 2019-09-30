package com.jhonjimenez.intergrupotestv2.data.repository

import com.jhonjimenez.intergrupotestv2.domain.entities.Result
import com.jhonjimenez.intergrupotestv2.domain.entities.SignInRequest
import com.jhonjimenez.intergrupotestv2.domain.entities.SignInResponse

interface SignInRepository {
    suspend fun signIn(signInRequest: SignInRequest, remenberMe: Boolean): Result<SignInResponse>
    suspend fun isRemenberMe(): Result<SignInRequest>
}
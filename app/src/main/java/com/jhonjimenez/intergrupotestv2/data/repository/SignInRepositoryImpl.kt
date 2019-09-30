package com.jhonjimenez.intergrupotestv2.data.repository

import com.google.gson.Gson
import com.jhonjimenez.intergrupotestv2.data.data_source.api.SignInApiSource
import com.jhonjimenez.intergrupotestv2.data.data_source.local.SignInLocalSource
import com.jhonjimenez.intergrupotestv2.domain.entities.Error
import com.jhonjimenez.intergrupotestv2.domain.entities.Result
import com.jhonjimenez.intergrupotestv2.domain.entities.SignInRequest
import com.jhonjimenez.intergrupotestv2.domain.entities.SignInResponse

class SignInRepositoryImpl(
    private val signInApiSource: SignInApiSource,
    private val signInLocalSource: SignInLocalSource
) : SignInRepository {

    override suspend fun signIn(
        signInRequest: SignInRequest,
        remenberMe: Boolean
    ): Result<SignInResponse> {
        val response = signInApiSource.signIn(signInRequest.email, signInRequest.password)

        if (response.isSuccessful) {
            response.body()?.let {
                if (remenberMe) signInLocalSource.saveCredentials(signInRequest)

                return Result.Success(it)
            }
        }

        val error = Gson().fromJson(response.errorBody()?.string(), Error::class.java)
        return Result.ErrorRepository(error)

    }

    override suspend fun isRemenberMe(): Result<SignInRequest> {
        return signInLocalSource.getCredentials()
    }


}




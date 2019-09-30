package com.jhonjimenez.intergrupotestv2.data.data_source.api

import com.jhonjimenez.intergrupotestv2.domain.entities.SignInResponse
import retrofit2.Response

class SignInApiSourceImpl : SignInApiSource {

    override suspend fun signIn(email: String, password: String): Response<SignInResponse> {

        val service = RetrofitFactory.makeRetrofitService()
        return service.signIn(email, password)
    }

}
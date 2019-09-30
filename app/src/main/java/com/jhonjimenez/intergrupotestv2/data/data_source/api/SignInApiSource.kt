package com.jhonjimenez.intergrupotestv2.data.data_source.api

import com.jhonjimenez.intergrupotestv2.domain.entities.Result
import com.jhonjimenez.intergrupotestv2.domain.entities.SignInRequest
import com.jhonjimenez.intergrupotestv2.domain.entities.SignInResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query

interface SignInApiSource {

    @GET("login")
    suspend fun signIn(@Query("email") email: String, @Query("password") password: String): Response<SignInResponse>

}
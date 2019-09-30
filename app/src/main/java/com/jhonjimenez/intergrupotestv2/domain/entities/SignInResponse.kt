package com.jhonjimenez.intergrupotestv2.domain.entities

data class SignInResponse(val success: Boolean, val authToken: String, val email: String)
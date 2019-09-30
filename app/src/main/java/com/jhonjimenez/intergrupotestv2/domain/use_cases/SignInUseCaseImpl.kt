package com.jhonjimenez.intergrupotestv2.domain.use_cases

import com.jhonjimenez.intergrupotestv2.data.repository.SignInRepository
import com.jhonjimenez.intergrupotestv2.domain.entities.Result
import com.jhonjimenez.intergrupotestv2.domain.entities.SignInRequest
import com.jhonjimenez.intergrupotestv2.domain.entities.SignInResponse
import com.jhonjimenez.intergrupotestv2.presentation.utlis.isEmailValid

class SignInUseCaseImpl(private val signInRepository: SignInRepository) : SignInUseCase {

    override suspend fun getCredentials(): Result<SignInRequest> {
       return signInRepository.isRemenberMe()
    }

    override suspend fun signIn(signInRequest: SignInRequest, remenberMe: Boolean): Result<SignInResponse> {

        val errors: HashMap<String, String> = HashMap()

        if (signInRequest.email.isEmpty()) {
            errors["email"] = "Debes ingresar tu correo electrónico"
        }

        if(signInRequest.email.isNotEmpty() && !isEmailValid(signInRequest.email)){
            errors["email"] = "Debes ingresar un correo valido"
        }

        if (signInRequest.password.isEmpty()) {
            errors["password"] = "Debes ingresar tu contraseña"
        }

        if (signInRequest.password.length < 7) {
            errors["password"] = "Debes ingresar minimo 7 caracteres"
        }

        if (errors.isNotEmpty()) {
            return Result.ErrorUseCase(errors)
        }

        return signInRepository.signIn(signInRequest, remenberMe)
    }

}
package com.jhonjimenez.intergrupotestv2.domain.entities

sealed class Result<out T> {

    data class Success<T>(val data: T) : Result<T>()
    data class ErrorUseCase(val errors: HashMap<String, String>) : Result<Nothing>()
    data class ErrorRepository(val error: Error) : Result<Nothing>()

}
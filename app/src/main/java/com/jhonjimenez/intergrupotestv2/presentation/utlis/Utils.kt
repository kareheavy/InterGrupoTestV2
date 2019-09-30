package com.jhonjimenez.intergrupotestv2.presentation.utlis

fun isEmailValid(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
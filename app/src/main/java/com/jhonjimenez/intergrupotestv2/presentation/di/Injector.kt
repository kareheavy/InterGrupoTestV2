package com.jhonjimenez.intergrupotestv2.presentation.di

import com.jhonjimenez.intergrupotestv2.data.data_source.api.SignInApiSource
import com.jhonjimenez.intergrupotestv2.data.data_source.api.SignInApiSourceImpl
import com.jhonjimenez.intergrupotestv2.data.data_source.local.SignInLocalSource
import com.jhonjimenez.intergrupotestv2.data.data_source.local.SignInLocalSourceImpl
import com.jhonjimenez.intergrupotestv2.data.repository.SignInRepository
import com.jhonjimenez.intergrupotestv2.data.repository.SignInRepositoryImpl
import com.jhonjimenez.intergrupotestv2.domain.use_cases.SignInUseCase
import com.jhonjimenez.intergrupotestv2.domain.use_cases.SignInUseCaseImpl

class Injector{

    fun provideSignInUsesCase() : SignInUseCase = SignInUseCaseImpl(provideSignInRepository())

    fun provideSignInRepository() : SignInRepository = SignInRepositoryImpl(provideSignInApiSource(), provideSignInLocalSource())

    fun provideSignInApiSource() : SignInApiSource =
        SignInApiSourceImpl()

    fun provideSignInLocalSource() : SignInLocalSource =
        SignInLocalSourceImpl()
}
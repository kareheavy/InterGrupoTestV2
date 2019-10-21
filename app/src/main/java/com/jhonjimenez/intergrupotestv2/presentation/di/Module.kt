package com.jhonjimenez.intergrupotestv2.presentation.di

import com.jhonjimenez.intergrupotestv2.data.data_source.api.*
import com.jhonjimenez.intergrupotestv2.data.data_source.local.SignInLocalSource
import com.jhonjimenez.intergrupotestv2.data.data_source.local.SignInLocalSourceImpl
import com.jhonjimenez.intergrupotestv2.data.repository.SignInRepository
import com.jhonjimenez.intergrupotestv2.data.repository.SignInRepositoryImpl
import com.jhonjimenez.intergrupotestv2.domain.use_cases.SignInUseCase
import com.jhonjimenez.intergrupotestv2.domain.use_cases.SignInUseCaseImpl
import com.jhonjimenez.intergrupotestv2.presentation.Prefs
import com.jhonjimenez.intergrupotestv2.presentation.ui.SignInViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


class Module {

    companion object {

        val sharedPreferencesModule = module{
            single{ Prefs(androidContext())}
        }

        val networkModule = module {
            //Retrofit Client
            factory { provideHttpLoggingInterceptor() }
            factory { provideOkHttpClient(get()) }
            single { provideRetrofit(get()) }
            //Apis
            factory {  provideSignInApi(get())}

        }

        val signInModule = module {

            single<SignInLocalSource> { SignInLocalSourceImpl(get()) }

            single<SignInRepository> { SignInRepositoryImpl(get(), get()) }

            single<SignInUseCase> { SignInUseCaseImpl(get()) }

            viewModel { SignInViewModel(get()) }
        }
    }
}
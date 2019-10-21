const val kotlinVersion = "1.3.41"

object Build {
    object Versions {
        const val buildToolsVersion = "3.5.1"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"

}

object Pluggins{
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
}

object AndroidSdk {
    const val min = 16
    const val compile = 29
    const val target = compile
}

object Libraries {
    private object Versions {
        //Android X and UI
        const val appCompat = "1.1.0"
        const val constraintLayout = "1.1.3"
        const val material = "1.1.0-alpha08"
        const val lifecycle = "2.1.0"
        //Android Support
        const val support = "29.0.0"
        //Test
        const val junit = "4.12"
        const val runner = "1.2.0"
        const val espresso = "3.2.0"
        const val mockito = "1.5.0"
        //Coroutines
        const val coroutines = "1.1.1"
        //Retrofit
        const val retrofit = "2.6.0"
        const val okhttp = "3.12.0"
        //Koin
        const val koin = "2.0.1"
        //Converter
        const val gson = "2.8.5"

    }

    //Kotlin
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
    //AndroidX
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val material = "com.google.android.material:material:${Versions.material}"
    //Support
    const val design = "com.android.support:design:${Versions.support}"
    const val support = "com.android.support:support-v4:${Versions.support}"
    //Test
    const val junit = "junit:junit:${Versions.junit}"
    const val runner = "androidx.test:runner:${Versions.runner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val mockito = "com.nhaarman:mockito-kotlin-kt1.1:${Versions.mockito}"
    //Coroutines
    const val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    //Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_converter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttp_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    //Koin
    const val koin = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    //Converter
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

}
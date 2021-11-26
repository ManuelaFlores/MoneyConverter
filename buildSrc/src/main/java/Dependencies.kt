object Versions {
    const val kotlinPlugin = "1.5.31"

    const val androidCore = "1.6.0"
    const val appCompat = "1.3.1"
    const val material = "1.4.0"
    const val constraintLayout = "2.1.1"
    const val androidxNavigation = "2.3.5"
    const val safeArgs = "2.3.5"

    const val jUnit = "4.13.2"
    const val jUnitAndroidX = "1.1.3"

    const val koin = "3.1.3"

    const val moshi = "2.9.0"
}

object Dependencies {
    const val androidCore = "androidx.core:core-ktx:${Versions.androidCore}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.androidxNavigation}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.androidxNavigation}"
    const val navigationRuntime =
        "androidx.navigation:navigation-runtime:${Versions.androidxNavigation}"

    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val jUnitAndroidX = "androidx.test.ext:junit:${Versions.jUnitAndroidX}"

    const val koin = "io.insert-koin:koin-android:${Versions.koin}"

    const val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.moshi}"
    const val moshiCodeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"

}

object Plugins {
    const val safeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.safeArgs}"
}

object Config {

}
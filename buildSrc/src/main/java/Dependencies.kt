import Dependencies.annotationRoom
import Dependencies.appCompat
import Dependencies.archCore
import Dependencies.coroutines
import Dependencies.espressoCore
import Dependencies.extJunit
import Dependencies.fragment
import Dependencies.fragmentUI
import Dependencies.gson
import Dependencies.hilt
import Dependencies.hiltCompiler
import Dependencies.junit
import Dependencies.kotlinCore
import Dependencies.lifeCycle
import Dependencies.logginInterceptor
import Dependencies.material
import Dependencies.navigationFragment
import Dependencies.navigationUI
import Dependencies.okHttp
import Dependencies.picasso
import Dependencies.retrofit
import Dependencies.retrofitConverter
import Dependencies.room
import Dependencies.runner
import Dependencies.testCore
import Dependencies.testRoom
import Dependencies.testRule
import Dependencies.truth
import ext.androidTestImplementation
import ext.implementation
import ext.kapt
import ext.testImplementation
import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {

    /** General **/

    const val kotlinCore = "androidx.core:core-ktx:${Versions.kotlinCore}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val lifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.fragment}"
    const val fragmentUI = "androidx.navigation:navigation-ui-ktx:${Versions.fragment}"
    const val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"

    /** Database **/
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val annotationRoom = "androidx.room:room-compiler:${Versions.room}"
    const val testRoom = "androidx.room:room-testing:${Versions.room}"

    /** Testing **/

    const val junit = "junit:junit:${Versions.junit}"
    const val runner = "androidx.test:runner:${Versions.extJunit}"
    const val testCore = "androidx.test:core:${Versions.testCore}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val truth = "com.google.truth:truth:${Versions.truth}"
    const val archCore = "android.arch.core:core-testing:${Versions.archCore}"
    const val testRule = "androidx.test:rules:${Versions.testRule}"

    /** Network **/

    val gson by lazy { "com.google.code.gson:gson:${Versions.gsonVersion}" }
    val okHttp by lazy { "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}" }
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}" }
    val retrofitConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}" }
    val logginInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}" }

    /** DI **/

    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }

    /** Navigation **/

    val navigationUI by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}" }
    val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}" }
}

/** Dependencies **/

fun DependencyHandler.general() {
    implementation(material)
    implementation(appCompat)
    implementation(lifeCycle)
    implementation(coroutines)
    implementation(kotlinCore)
    implementation(fragment)
    implementation(fragmentUI)
    implementation(picasso)
}

fun DependencyHandler.database() {
    implementation(room)
    kapt(annotationRoom)
}

fun DependencyHandler.testing() {
    testImplementation(junit)
    testImplementation(testRoom)
    testImplementation(testCore)
    androidTestImplementation(junit)
    androidTestImplementation(runner)
    androidTestImplementation(testCore)
    androidTestImplementation(extJunit)
    androidTestImplementation(espressoCore)
    androidTestImplementation(truth)
    androidTestImplementation(archCore)
    androidTestImplementation(testRule)
    androidTestImplementation(testRoom)
}

fun DependencyHandler.network() {
    implementation(gson)
    implementation(okHttp)
    implementation(retrofit)
    implementation(logginInterceptor)
    implementation(retrofitConverter)
}

fun DependencyHandler.di() {
    kapt(hiltCompiler)
    implementation(hilt)
}

fun DependencyHandler.navigation() {
    implementation(navigationUI)
    implementation(navigationFragment)
}

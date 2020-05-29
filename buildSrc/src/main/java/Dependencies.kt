import org.gradle.api.JavaVersion

object Config {
    val minSdk = 21
    val compileSdk = 29
    val targetSdk = 29
    val javaVersion = JavaVersion.VERSION_1_8
    val buildTools = "29.0.2"
}

object Versions {

    /*androidx*/
    val androidxCore = "1.0.1"
    val androidxLifecycle = "2.1.0"
    val gradleAndroid = "3.5.1"

    /*android google*/
    val material = "1.1.0"

    /*kotlin*/
    val kotlin = "1.3.50"
    val coroutinesCore = "1.1.0"
    val coroutinesAndroid = "1.1.0"

    val lastAdapter = "2.3.0"
    val permissionDispatcher = "4.6.0"
}

object Deps {

    /*kotlin*/
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"

    /*androidx*/
    val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    val androidxLifecycle = "androidx.lifecycle:lifecycle-common-java8:${Versions.androidxLifecycle}"
    val androidxLifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.androidxLifecycle}"
    val androidxLifecycleViewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifecycle}"

    /*android google*/
    val material = "com.google.android.material:material:${Versions.material}"

    val lastAdapter = "com.github.nitrico.lastadapter:lastadapter:${Versions.lastAdapter}"
    val kaptDataBinding = "com.android.databinding:compiler:${Versions.gradleAndroid}"
    val permissionDispatcher = "org.permissionsdispatcher:permissionsdispatcher:${Versions.permissionDispatcher}"
    val kaptPermissionDispatcher = "org.permissionsdispatcher:permissionsdispatcher-processor:${Versions.permissionDispatcher}"
}
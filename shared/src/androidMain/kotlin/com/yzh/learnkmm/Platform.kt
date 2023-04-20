package com.yzh.learnkmm

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()
actual fun getHttpClient(): HttpClient = HttpClient(Android)
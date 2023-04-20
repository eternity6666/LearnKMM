package com.yzh.learnkmm

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpMethod
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Greeting {
    private val platform: Platform = getPlatform()
    private val client: HttpClient = getHttpClient()

    private val _data = MutableStateFlow("")
    val data: StateFlow<String> = _data

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    suspend fun request() {
        val response = client.get("https://api.doctorxiong.club/v1/fund/detail/list?code=000001") {
            method = HttpMethod.Get
        }
        _data.emit(response.body())
    }
}

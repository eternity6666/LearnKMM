package com.yzh.learnkmm

import io.ktor.client.HttpClient

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun getHttpClient(): HttpClient
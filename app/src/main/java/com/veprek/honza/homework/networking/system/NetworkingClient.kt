package com.veprek.honza.homework.networking.system

import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.statement.HttpResponse

interface NetworkingClient {
    suspend fun get(
        path: String,
        block: HttpRequestBuilder.() -> Unit = {},
    ): HttpResponse
}
package com.veprek.honza.homework.networking.system

import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.statement.HttpResponse

internal interface NetworkingClient {
    suspend fun get(
        path: String,
        block: HttpRequestBuilder.() -> Unit = {},
    ): HttpResponse
}
package com.veprek.honza.homework.networking.system

import com.veprek.honza.homework.networking.model.Environment
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

internal class KtorNetworkingClient(
    private val httpClient: HttpClient
) : NetworkingClient {
    override suspend fun get(
        path: String,
        block: HttpRequestBuilder.() -> Unit
    ): HttpResponse {
        return httpClient.get("$BASE_URL/$path") {
            block()
        }
    }

    private companion object {
        val BASE_URL = Environment.DEVELOP.baseUrl
    }
}
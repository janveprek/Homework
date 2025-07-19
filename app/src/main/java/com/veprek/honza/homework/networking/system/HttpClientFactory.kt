package com.veprek.honza.homework.networking.system

import android.util.Log
import com.veprek.honza.homework.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class HttpClientFactory {
    
    fun create(): HttpClient {
        return HttpClient {
            expectSuccess = true

            install(ContentNegotiation) {
                json(
                    Json {
                        useAlternativeNames = false
                        isLenient = false
                        ignoreUnknownKeys = true
                    }
                )
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.v("HTTP Client", message)
                    }
                }
                level = LogLevel.INFO
            }

            defaultRequest {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                header("WEB-API-key", BuildConfig.WEB_API_KEY)
            }
        }
    }
}

package com.veprek.honza.homework.networking.di

import com.veprek.honza.homework.networking.system.HttpClientFactory
import com.veprek.honza.homework.networking.system.KtorNetworkingClient
import com.veprek.honza.homework.networking.system.NetworkingClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkingModule = module {
    singleOf(::HttpClientFactory)
    single { get<HttpClientFactory>().create() }
    single<NetworkingClient> {
        val httpClient = get<HttpClientFactory>().create()
        KtorNetworkingClient(httpClient)
    }
}

package com.veprek.honza.homework.networking.model

internal enum class Environment(val baseUrl: String) {
    DEVELOP("https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v3"),
    PRODUCTION("https://www.csas.cz/webapi/api/v3")
}
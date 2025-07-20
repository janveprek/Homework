package com.veprek.honza.homework.core.model

import kotlinx.serialization.Serializable
sealed interface Screen {
    @Serializable
    data object AccountsList : Screen

    @Serializable
    data class AccountDetail(val code: String) : Screen
}

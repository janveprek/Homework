package com.veprek.honza.homework.accountdetail.presentation.state

internal data class TransparentAccountDetailState(
    val accountNumber: String,
    val actualizationDate: String,
    val balance: String,
    val name: String,
    val description: String,
    val iban: String
) {
    companion object {
        val Default = TransparentAccountDetailState(
            accountNumber = "",
            actualizationDate = "",
            balance = "",
            name = "",
            description = "",
            iban = "",
        )
    }
}
package com.veprek.honza.homework.account.presentation.state

internal data class TransparentAccountItemState(
    val accountNumber: String,
    val bankCode: String,
    val balance: String,
    val currency: String,
    val name: String,
)
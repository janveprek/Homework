package com.veprek.honza.homework.account.presentation.mapper

import com.veprek.honza.homework.account.model.TransparentAccount
import com.veprek.honza.homework.account.presentation.state.TransparentAccountItemState
import com.veprek.honza.homework.design.presentation.mapper.toFormattedCurrency

internal fun TransparentAccount.toItemState(): TransparentAccountItemState {
    return TransparentAccountItemState(
        accountNumber = accountNumber,
        bankCode = bankCode,
        balance = balance.toFormattedCurrency(currency),
        currency = currency,
        name = name,
    )
}

internal fun List<TransparentAccount>.toItemStates(): List<TransparentAccountItemState> =
    map { it.toItemState() }
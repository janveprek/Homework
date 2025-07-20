package com.veprek.honza.homework.accountdetail.presentation.mapper

import com.veprek.honza.homework.account.model.TransparentAccount
import com.veprek.honza.homework.accountdetail.ui.TransparentAccountDetailState
import com.veprek.honza.homework.design.presentation.mapper.toFormattedCurrency
import com.veprek.honza.homework.design.presentation.mapper.toFormattedUiDate

internal fun TransparentAccount.toDetailState(): TransparentAccountDetailState {
    return TransparentAccountDetailState(
        accountNumber = "$accountNumber/$bankCode",
        balance = balance.toFormattedCurrency(currency),
        name = name,
        actualizationDate = actualizationDate?.toFormattedUiDate() ?: "",
        description = description,
        iban = iban
    )
}



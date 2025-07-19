package com.veprek.honza.homework.account.ui

import com.veprek.honza.homework.account.model.TransparentAccount
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

fun TransparentAccount.toItemState(): TransparentAccountItemState {
    // TODO: Better formatting
    val decimalFormat = DecimalFormat("#,##0.00", DecimalFormatSymbols(Locale("cs", "CZ")))
    val formattedBalance = decimalFormat.format(balance)

    return TransparentAccountItemState(
        accountNumber = accountNumber,
        bankCode = bankCode,
        balance = "$formattedBalance $currency",
        currency = currency,
        name = name,
        iban = iban
    )
}

fun List<TransparentAccount>.toItemStates(): List<TransparentAccountItemState> =
    map { it.toItemState() }
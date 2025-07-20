package com.veprek.honza.homework.accountdetail.presentation.mapper

import com.veprek.honza.homework.account.model.Transaction
import com.veprek.honza.homework.accountdetail.presentation.state.TransactionState
import com.veprek.honza.homework.design.presentation.mapper.toFormattedCurrency
import com.veprek.honza.homework.design.presentation.mapper.toFormattedUiDate

internal fun Transaction.toState(): TransactionState {
    val formattedAmount = amount.value.toFormattedCurrency(amount.currency)

    return TransactionState(
        amount = formattedAmount,
        processingDate = processingDate?.toFormattedUiDate(),
        senderAccountNumber = sender?.accountNumber,
        receiverAccountNumber = receiver?.accountNumber,
        senderName = sender?.name,
        receiverName = receiver?.name,
        senderDescription = sender?.description,
        receiverDescription = receiver?.description,
        typeDescription = typeDescription,
    )
}

internal fun List<Transaction>.toStates(): List<TransactionState> =
    map { it.toState() }
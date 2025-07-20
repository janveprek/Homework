package com.veprek.honza.homework.accountdetail.presentation.state

internal data class TransactionState(
    val amount: String,
    val processingDate: String?,
    val senderAccountNumber: String?,
    val receiverAccountNumber: String?,
    val senderName: String?,
    val receiverName: String?,
    val senderDescription: String?,
    val receiverDescription: String?,
    val typeDescription: String,
)
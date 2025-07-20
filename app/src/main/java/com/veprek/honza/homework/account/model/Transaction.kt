package com.veprek.honza.homework.account.model

import kotlinx.datetime.LocalDateTime

data class Transaction(
    val amount: TransactionAmount,
    val type: String,
    val typeDescription: String,
    val dueDate: LocalDateTime?,
    val processingDate: LocalDateTime?,
    val sender: TransactionParty?,
    val receiver: TransactionParty?,
)

data class TransactionAmount(
    val value: Double,
    val currency: String,
)

data class TransactionParty(
    val accountNumber: String,
    val bankCode: String,
    val iban: String?,
    val name: String?,
    val description: String?,
)
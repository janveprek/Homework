package com.veprek.honza.homework.account.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class TransactionsResponseDto(
    @SerialName("pageNumber")
    val pageNumber: Int,
    @SerialName("pageSize")
    val pageSize: Int,
    @SerialName("pageCount")
    val pageCount: Int,
    @SerialName("nextPage")
    val nextPage: Int?,
    @SerialName("recordCount")
    val recordCount: Int,
    @SerialName("transactions")
    val transactions: List<TransactionDto>
)

@Serializable
internal data class TransactionDto(
    @SerialName("amount")
    val amount: TransactionAmountDto,
    @SerialName("type")
    val type: String,
    @SerialName("typeDescription")
    val typeDescription: String? = null,
    @SerialName("dueDate")
    val dueDate: String? = null,
    @SerialName("processingDate")
    val processingDate: String? = null,
    @SerialName("sender")
    val sender: TransactionPartyDto? = null,
    @SerialName("receiver")
    val receiver: TransactionPartyDto? = null,
)

@Serializable
internal data class TransactionAmountDto(
    @SerialName("value")
    val value: Double,
    @SerialName("currency")
    val currency: String,
)

@Serializable
internal data class TransactionPartyDto(
    @SerialName("accountNumber")
    val accountNumber: String,
    @SerialName("bankCode")
    val bankCode: String,
    @SerialName("iban")
    val iban: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("description")
    val description: String? = null,
)
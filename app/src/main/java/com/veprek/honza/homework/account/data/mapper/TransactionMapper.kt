package com.veprek.honza.homework.account.data.mapper

import com.veprek.honza.homework.account.data.entity.TransactionAmountDto
import com.veprek.honza.homework.account.data.entity.TransactionDto
import com.veprek.honza.homework.account.data.entity.TransactionPartyDto
import com.veprek.honza.homework.account.data.entity.TransactionsRequestDto
import com.veprek.honza.homework.account.data.entity.TransactionsResponseDto
import com.veprek.honza.homework.account.model.Transaction
import com.veprek.honza.homework.account.model.TransactionAmount
import com.veprek.honza.homework.account.model.TransactionParty
import com.veprek.honza.homework.account.model.TransactionsRequest
import com.veprek.honza.homework.networking.model.PagingListResult
import kotlinx.datetime.LocalDateTime

internal fun TransactionsRequest.toDto() = TransactionsRequestDto(
    page = page,
    size = perPage,
)

internal fun TransactionDto.toModel(): Transaction {
    return Transaction(
        amount = amount.toModel(),
        type = type,
        typeDescription = typeDescription ?: "",
        dueDate = dueDate?.let { LocalDateTime.parse(it) },
        processingDate = processingDate?.let { LocalDateTime.parse(it) },
        sender = sender?.toModel(),
        receiver = receiver?.toModel(),
    )
}

internal fun TransactionAmountDto.toModel(): TransactionAmount {
    return TransactionAmount(
        value = value,
        currency = currency,
    )
}

internal fun TransactionPartyDto.toModel(): TransactionParty {
    return TransactionParty(
        accountNumber = accountNumber,
        bankCode = bankCode,
        iban = iban,
        description = description,
        name = name,
    )
}

internal fun List<TransactionDto>?.toModel(): List<Transaction> =
    this?.map { it.toModel() } ?: emptyList()

internal fun TransactionsResponseDto.toModel(): PagingListResult<Transaction> {
    val transactions = this.transactions.toModel()
    return PagingListResult(
        currentPage = pageNumber,
        pageCount = pageCount,
        items = transactions
    )
}
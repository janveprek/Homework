package com.veprek.honza.homework.account.data.mapper

import com.veprek.honza.homework.account.data.entity.TransparentAccountDto
import com.veprek.honza.homework.account.data.entity.TransparentAccountsRequestDto
import com.veprek.honza.homework.account.data.entity.TransparentAccountsResponseDto
import com.veprek.honza.homework.account.model.TransparentAccount
import com.veprek.honza.homework.account.model.TransparentAccountsRequest
import com.veprek.honza.homework.networking.model.PagingListResult
import kotlinx.datetime.LocalDateTime

fun TransparentAccountsRequest.toDto() = TransparentAccountsRequestDto(
    page = page,
    size = perPage,
)

fun TransparentAccountDto.toModel(): TransparentAccount {
    return TransparentAccount(
        accountNumber = accountNumber,
        bankCode = bankCode ?: "",
        transparencyFrom = transparencyFrom?.let { LocalDateTime.parse(it) },
        transparencyTo = transparencyTo?.let { LocalDateTime.parse(it) },
        publicationTo = publicationTo?.let { LocalDateTime.parse(it) },
        actualizationDate = actualizationDate?.let { LocalDateTime.parse(it) },
        balance = balance ?: 0.0,
        currency = currency ?: "",
        name = name ?: "",
        iban = iban ?: "",
    )
}

fun List<TransparentAccountDto>?.toModel(): List<TransparentAccount> =
    this?.map { it.toModel() } ?: emptyList()

fun TransparentAccountsResponseDto.toModel(): PagingListResult<TransparentAccount> {
    val accounts = this.accounts.toModel()
    return PagingListResult(
        currentPage = pageNumber,
        pageCount = pageCount,
        items = accounts
    )
}

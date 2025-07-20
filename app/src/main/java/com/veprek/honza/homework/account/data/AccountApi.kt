package com.veprek.honza.homework.account.data

import com.veprek.honza.homework.account.data.entity.TransactionsRequestDto
import com.veprek.honza.homework.account.data.entity.TransactionsResponseDto
import com.veprek.honza.homework.account.data.entity.TransparentAccountDetailDto
import com.veprek.honza.homework.account.data.entity.TransparentAccountsRequestDto
import com.veprek.honza.homework.account.data.entity.TransparentAccountsResponseDto

internal interface AccountApi {
    suspend fun getTransparentAccounts(
        request: TransparentAccountsRequestDto,
    ): TransparentAccountsResponseDto

    suspend fun getTransparentAccountDetail(
        accountNumber: String,
    ): TransparentAccountDetailDto

    suspend fun getTransactionsForAccount(
        accountId: String,
        request: TransactionsRequestDto,
    ): TransactionsResponseDto
}
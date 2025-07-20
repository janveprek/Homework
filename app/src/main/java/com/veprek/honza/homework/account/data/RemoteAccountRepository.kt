package com.veprek.honza.homework.account.data

import com.veprek.honza.homework.account.data.mapper.toDto
import com.veprek.honza.homework.account.data.mapper.toModel
import com.veprek.honza.homework.account.domain.AccountRepository
import com.veprek.honza.homework.account.model.Transaction
import com.veprek.honza.homework.account.model.TransactionsRequest
import com.veprek.honza.homework.account.model.TransparentAccount
import com.veprek.honza.homework.account.model.TransparentAccountsRequest
import com.veprek.honza.homework.core.model.DataResult
import com.veprek.honza.homework.core.model.apiDataResult
import com.veprek.honza.homework.networking.model.PagingListResult

internal class RemoteAccountRepository(
    private val apiService: AccountApi,
) : AccountRepository {
    override suspend fun getTransparentAccounts(
        request: TransparentAccountsRequest
    ): DataResult<PagingListResult<TransparentAccount>> = apiDataResult {
        val response = apiService.getTransparentAccounts(request.toDto())
        response.toModel()
    }

    override suspend fun getTransparentAccountDetail(
        accountNumber: String
    ): DataResult<TransparentAccount> = apiDataResult {
        val response = apiService.getTransparentAccountDetail(accountNumber)
        response.toModel()
    }

    override suspend fun getTransactions(
        request: TransactionsRequest
    ): DataResult<PagingListResult<Transaction>> = apiDataResult {
        val response = apiService.getTransactionsForAccount(request.accountId, request.toDto())
        response.toModel()
    }
}
package com.veprek.honza.homework.account.data

import com.veprek.honza.homework.account.data.mapper.toDto
import com.veprek.honza.homework.account.data.mapper.toModel
import com.veprek.honza.homework.account.model.TransparentAccount
import com.veprek.honza.homework.account.domain.AccountRepository
import com.veprek.honza.homework.account.model.TransparentAccountsRequest
import com.veprek.honza.homework.core.model.DataResult
import com.veprek.honza.homework.core.model.apiDataResult
import com.veprek.honza.homework.networking.model.PagingListResult

class RemoteAccountRepository(
    private val apiService: AccountApi,
) : AccountRepository {
    override suspend fun getTransparentAccounts(
        request: TransparentAccountsRequest
    ): DataResult<PagingListResult<TransparentAccount>> = apiDataResult {
        val response = apiService.getTransparentAccounts(request.toDto())
        response.toModel()
    }
}
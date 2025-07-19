package com.veprek.honza.homework.account.domain

import com.veprek.honza.homework.account.model.TransparentAccount
import com.veprek.honza.homework.account.model.TransparentAccountsRequest
import com.veprek.honza.homework.core.model.DataResult
import com.veprek.honza.homework.networking.model.PagingListResult

interface AccountRepository {
    suspend fun getTransparentAccounts(
        request: TransparentAccountsRequest
    ): DataResult<PagingListResult<TransparentAccount>>
}
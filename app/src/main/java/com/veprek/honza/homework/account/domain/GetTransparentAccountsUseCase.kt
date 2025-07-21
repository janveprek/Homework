package com.veprek.honza.homework.account.domain

import com.veprek.honza.homework.account.model.TransparentAccount
import com.veprek.honza.homework.account.model.TransparentAccountsRequest
import com.veprek.honza.homework.core.model.DataResult
import com.veprek.honza.homework.networking.model.PagingListResult

/**
 * Returns transparent accounts in the paginated list
 */
internal interface GetTransparentAccountsUseCase {
    suspend operator fun invoke(request: TransparentAccountsRequest): DataResult<PagingListResult<TransparentAccount>>
}

internal class GetTransparentAccountsUseCaseImpl(
    private val repository: AccountRepository
): GetTransparentAccountsUseCase {
    override suspend operator fun invoke(
        request: TransparentAccountsRequest
    ): DataResult<PagingListResult<TransparentAccount>> {
        return repository.getTransparentAccounts(request)
    }
}
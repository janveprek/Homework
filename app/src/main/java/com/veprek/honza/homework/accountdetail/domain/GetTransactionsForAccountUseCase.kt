package com.veprek.honza.homework.accountdetail.domain

import com.veprek.honza.homework.account.domain.AccountRepository
import com.veprek.honza.homework.account.model.Transaction
import com.veprek.honza.homework.account.model.TransactionsRequest
import com.veprek.honza.homework.core.model.DataResult
import com.veprek.honza.homework.networking.model.PagingListResult

/**
 * Returns transactions for given account, in the paginated list
 */
internal interface GetTransactionsForAccountUseCase {
    suspend operator fun invoke(request: TransactionsRequest): DataResult<PagingListResult<Transaction>>
}

internal class GetTransactionsForAccountUseCaseImpl(
    private val repository: AccountRepository
) : GetTransactionsForAccountUseCase {
    override suspend operator fun invoke(
        request: TransactionsRequest
    ): DataResult<PagingListResult<Transaction>> {
        return repository.getTransactions(request)
    }
}

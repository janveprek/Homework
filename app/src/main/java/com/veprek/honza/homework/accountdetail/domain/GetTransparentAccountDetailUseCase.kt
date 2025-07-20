package com.veprek.honza.homework.accountdetail.domain

import com.veprek.honza.homework.account.domain.AccountRepository
import com.veprek.honza.homework.account.model.TransparentAccount
import com.veprek.honza.homework.core.model.DataResult

/**
 * Returns transparent account by its number
 */
internal interface GetTransparentAccountDetailUseCase {
    suspend operator fun invoke(accountNumber: String): DataResult<TransparentAccount>
}

internal class GetTransparentAccountDetailUseCaseImpl(
    private val repository: AccountRepository
) : GetTransparentAccountDetailUseCase {
    override suspend operator fun invoke(
        accountNumber: String
    ): DataResult<TransparentAccount> {
        return repository.getTransparentAccountDetail(accountNumber)
    }
}

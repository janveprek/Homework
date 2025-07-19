package com.veprek.honza.homework.account.data

import com.veprek.honza.homework.account.data.entity.TransparentAccountsRequestDto
import com.veprek.honza.homework.account.data.entity.TransparentAccountsResponseDto

interface AccountApi {
    suspend fun getTransparentAccounts(
        request: TransparentAccountsRequestDto,
    ): TransparentAccountsResponseDto
}
package com.veprek.honza.homework.account.system

import com.veprek.honza.homework.account.data.AccountApi
import com.veprek.honza.homework.account.data.entity.TransactionsRequestDto
import com.veprek.honza.homework.account.data.entity.TransactionsResponseDto
import com.veprek.honza.homework.account.data.entity.TransparentAccountDetailDto
import com.veprek.honza.homework.account.data.entity.TransparentAccountsRequestDto
import com.veprek.honza.homework.account.data.entity.TransparentAccountsResponseDto
import com.veprek.honza.homework.networking.system.NetworkingClient
import io.ktor.client.call.body
import io.ktor.client.request.parameter

internal class RemoteAccountApi(
    private val networkingClient: NetworkingClient
): AccountApi {

    override suspend fun getTransparentAccounts(
        request: TransparentAccountsRequestDto,
    ): TransparentAccountsResponseDto {
        val path = "transparentAccounts"
        val response = networkingClient.get(path) {
            parameter("page", request.page)
            parameter("size", request.size)
        }
        return response.body()
    }

    override suspend fun getTransparentAccountDetail(
        accountNumber: String,
    ): TransparentAccountDetailDto {
        val path = "transparentAccounts/$accountNumber"
        val response = networkingClient.get(path)
        return response.body()
    }

    override suspend fun getTransactionsForAccount(
        accountId: String,
        request: TransactionsRequestDto,
    ): TransactionsResponseDto {
        val path = "transparentAccounts/$accountId/transactions"
        val response = networkingClient.get(path) {
            parameter("page", request.page)
            parameter("size", request.size)
        }
        return response.body()
    }
}
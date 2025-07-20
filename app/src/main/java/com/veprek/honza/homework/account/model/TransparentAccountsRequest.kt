package com.veprek.honza.homework.account.model

private const val PER_PAGE = 10

data class TransparentAccountsRequest(
    val page: Int,
    val perPage: Int = PER_PAGE,
)

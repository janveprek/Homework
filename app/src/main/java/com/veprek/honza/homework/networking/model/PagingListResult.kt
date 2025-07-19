package com.veprek.honza.homework.networking.model

data class PagingListResult<out T>(
    val items: List<T>,
    val currentPage: Int,
    val pageCount: Int,
)
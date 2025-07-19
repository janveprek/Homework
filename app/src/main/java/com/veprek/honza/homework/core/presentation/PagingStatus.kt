package com.veprek.honza.homework.core.presentation

sealed interface PagingStatus {
    data object Loading : PagingStatus
    data object Error : PagingStatus
    data object Ready : PagingStatus
}
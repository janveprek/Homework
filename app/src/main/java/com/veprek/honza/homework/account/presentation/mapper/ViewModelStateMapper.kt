package com.veprek.honza.homework.account.presentation.mapper

import com.veprek.honza.homework.account.presentation.state.TransparentAccountsScreenState
import com.veprek.honza.homework.account.presentation.state.ViewModelState
import com.veprek.honza.homework.core.presentation.PagingStatus

internal fun ViewModelState.toUiState(): TransparentAccountsScreenState {
    return TransparentAccountsScreenState(
        accounts = accounts.toItemStates(),
        uiStatus = uiStatus,
        currentPage = currentPage,
        totalPages = totalPages,
        isPageLoading = pagingStatus == PagingStatus.Loading
    )
}
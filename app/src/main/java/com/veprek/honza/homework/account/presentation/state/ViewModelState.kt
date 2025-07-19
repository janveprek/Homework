package com.veprek.honza.homework.account.presentation.state

import com.veprek.honza.homework.account.model.TransparentAccount
import com.veprek.honza.homework.account.ui.toItemStates
import com.veprek.honza.homework.core.presentation.PagingStatus
import com.veprek.honza.homework.core.presentation.UiStatus

data class ViewModelState(
    val accounts: List<TransparentAccount>,
    val uiStatus: UiStatus,
    val currentPage: Int,
    val totalPages: Int,
    val pagingStatus: PagingStatus,
) {
    companion object {
        val Default = ViewModelState(
            accounts = emptyList(),
            uiStatus = UiStatus.Ready,
            currentPage = 0,
            totalPages = 0,
            pagingStatus = PagingStatus.Ready,
        )
    }
}

internal fun ViewModelState.toUiState(): TransparentAccountsScreenState {
    return TransparentAccountsScreenState(
        accounts = accounts.toItemStates(),
        uiStatus = uiStatus,
        currentPage = currentPage,
        totalPages = totalPages,
        isPageLoading = pagingStatus == PagingStatus.Loading
    )
}
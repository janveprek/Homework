package com.veprek.honza.homework.account.presentation.state

import com.veprek.honza.homework.account.ui.TransparentAccountItemState
import com.veprek.honza.homework.core.presentation.UiStatus

internal data class TransparentAccountsScreenState(
    val accounts: List<TransparentAccountItemState>,
    val uiStatus: UiStatus,
    val currentPage: Int,
    val totalPages: Int,
    val isPageLoading: Boolean,
) {
    companion object {
        val Default = TransparentAccountsScreenState(
            accounts = emptyList(),
            uiStatus = UiStatus.Ready,
            currentPage = 0,
            totalPages = 0,
            isPageLoading = false
        )
    }
}
package com.veprek.honza.homework.accountdetail.presentation.state

import com.veprek.honza.homework.accountdetail.ui.TransparentAccountDetailState
import com.veprek.honza.homework.core.presentation.UiStatus

internal data class TransparentAccountDetailScreenState(
    val account: TransparentAccountDetailState,
    val transactions: List<TransactionState>,
    val uiStatus: UiStatus,
) {
    companion object {
        val Default = TransparentAccountDetailScreenState(
            account = TransparentAccountDetailState.Default,
            transactions = emptyList(),
            uiStatus = UiStatus.Ready,
        )
    }
}
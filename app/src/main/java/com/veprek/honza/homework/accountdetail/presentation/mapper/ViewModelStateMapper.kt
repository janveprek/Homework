package com.veprek.honza.homework.accountdetail.presentation.mapper

import com.veprek.honza.homework.accountdetail.presentation.state.TransparentAccountDetailScreenState
import com.veprek.honza.homework.accountdetail.presentation.state.ViewModelState
import com.veprek.honza.homework.accountdetail.ui.TransparentAccountDetailState

internal fun ViewModelState.toUiState(): TransparentAccountDetailScreenState {
    return TransparentAccountDetailScreenState(
        account = account?.toDetailState() ?: TransparentAccountDetailState.Default,
        transactions = transactions.toStates(),
        uiStatus = uiStatus,
    )
}
package com.veprek.honza.homework.accountdetail.presentation.state

import com.veprek.honza.homework.account.model.Transaction
import com.veprek.honza.homework.account.model.TransparentAccount
import com.veprek.honza.homework.core.presentation.PagingStatus
import com.veprek.honza.homework.core.presentation.UiStatus

internal data class ViewModelState(
    val account: TransparentAccount?,
    val transactions: List<Transaction>,
    val uiStatus: UiStatus,
    val pagingStatus: PagingStatus,
) {
    companion object {
        val Default = ViewModelState(
            account = null,
            transactions = emptyList(),
            uiStatus = UiStatus.Ready,
            pagingStatus = PagingStatus.Ready,
        )
    }
}

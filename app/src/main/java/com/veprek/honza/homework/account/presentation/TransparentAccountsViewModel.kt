package com.veprek.honza.homework.account.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.veprek.honza.homework.account.domain.GetTransparentAccountsUseCase
import com.veprek.honza.homework.account.model.TransparentAccountsRequest
import com.veprek.honza.homework.account.presentation.state.TransparentAccountsScreenState
import com.veprek.honza.homework.account.presentation.state.ViewModelState
import com.veprek.honza.homework.account.presentation.state.toUiState
import com.veprek.honza.homework.core.model.handle
import com.veprek.honza.homework.core.presentation.PagingStatus
import com.veprek.honza.homework.core.presentation.UiStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

internal class TransparentAccountsViewModel(
    private val getTransparentAccountsUseCase: GetTransparentAccountsUseCase,
) : ViewModel() {
    private val viewModelState = MutableStateFlow(ViewModelState.Default)
    val uiState: StateFlow<TransparentAccountsScreenState> =
        viewModelState.map { it.toUiState() }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = TransparentAccountsScreenState.Default,
    )

    init {
        loadFirstPage()
    }

    fun tryAgain() {
        loadFirstPage()
    }

    private fun loadFirstPage() {
        viewModelScope.launch {
            changeState {
                copy(
                    uiStatus = UiStatus.Loading,
                    pagingStatus = PagingStatus.Loading
                )
            }
            val result = getTransparentAccountsUseCase(TransparentAccountsRequest(page = 0))
            result.handle(
                onSuccess = { response ->
                    changeState {
                        copy(
                            accounts = response.data.items,
                            uiStatus = UiStatus.Ready,
                            currentPage = response.data.currentPage,
                            totalPages = response.data.pageCount,
                            pagingStatus = PagingStatus.Ready
                        )
                    }
                },
                onError = {
                    changeState {
                        copy(
                            uiStatus = UiStatus.Error,
                            pagingStatus = PagingStatus.Error
                        )
                    }
                }
            )
        }
    }

    private fun changeState(
        transform: ViewModelState.() -> ViewModelState,
    ) {
        viewModelState.value = transform(viewModelState.value)
    }
}
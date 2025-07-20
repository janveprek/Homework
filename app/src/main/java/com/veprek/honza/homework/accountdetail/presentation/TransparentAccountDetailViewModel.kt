package com.veprek.honza.homework.accountdetail.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.veprek.honza.homework.account.model.TransactionsRequest
import com.veprek.honza.homework.accountdetail.domain.GetTransactionsForAccountUseCase
import com.veprek.honza.homework.accountdetail.domain.GetTransparentAccountDetailUseCase
import com.veprek.honza.homework.accountdetail.presentation.mapper.toUiState
import com.veprek.honza.homework.accountdetail.presentation.state.TransparentAccountDetailScreenState
import com.veprek.honza.homework.accountdetail.presentation.state.ViewModelState
import com.veprek.honza.homework.core.model.Screen
import com.veprek.honza.homework.core.model.handle
import com.veprek.honza.homework.core.presentation.PagingStatus
import com.veprek.honza.homework.core.presentation.UiStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

internal class TransparentAccountDetailViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val getTransparentAccountDetailUseCase: GetTransparentAccountDetailUseCase,
    private val getTransactionsForAccountUseCase: GetTransactionsForAccountUseCase,
) : ViewModel() {
    private val accountNumber: String
        get() = savedStateHandle.toRoute<Screen.AccountDetail>().code

    private val viewModelState = MutableStateFlow(ViewModelState.Default)
    val uiState: StateFlow<TransparentAccountDetailScreenState> =
        viewModelState.map { it.toUiState() }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = TransparentAccountDetailScreenState.Default,
        )

    init {
        loadAccountDetail()
    }

    fun tryAgain() {
        loadAccountDetail()
    }

    private fun loadAccountDetail() {
        viewModelScope.launch {
            changeState {
                copy(
                    uiStatus = UiStatus.Loading,
                    pagingStatus = PagingStatus.Loading
                )
            }

            val accountResult = getTransparentAccountDetailUseCase(accountNumber)
            val transactionsResult = getTransactionsForAccountUseCase(
                TransactionsRequest(
                    accountId = accountNumber,
                    page = 0
                )
            )

            accountResult.handle(
                onSuccess = { account ->
                    changeState {
                        copy(
                            account = account.data,
                            uiStatus = UiStatus.Ready
                        )
                    }

                    transactionsResult.handle(
                        onSuccess = { transactionsResponse ->
                            changeState {
                                copy(
                                    transactions = transactionsResponse.data.items,
                                    pagingStatus = PagingStatus.Ready
                                )
                            }
                        },
                        onError = {
                            changeState {
                                copy(
                                    account = account.data,
                                    transactions = emptyList(),
                                    uiStatus = UiStatus.Ready,
                                    pagingStatus = PagingStatus.Error,
                                )
                            }
                        }
                    )
                },
                onError = {
                    changeState {
                        copy(uiStatus = UiStatus.Error)
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
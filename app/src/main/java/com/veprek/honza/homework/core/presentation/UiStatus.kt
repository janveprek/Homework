package com.veprek.honza.homework.core.presentation

sealed class UiStatus {
    data object Loading : UiStatus()
    data object Ready : UiStatus()
    data object Error : UiStatus()
}
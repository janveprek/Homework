package com.veprek.honza.homework.account.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.veprek.honza.homework.account.presentation.TransparentAccountsViewModel
import com.veprek.honza.homework.core.presentation.UiStatus
import com.veprek.honza.homework.design.ui.screen.ErrorScreen
import com.veprek.honza.homework.design.ui.screen.LoadingScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun TransparentAccountsScreen(
    viewModel: TransparentAccountsViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold { paddingValues ->
        when (uiState.uiStatus) {
            UiStatus.Loading -> {
                LoadingScreen(
                    modifier = Modifier.padding(paddingValues)
                )
            }

            UiStatus.Error -> {
                ErrorScreen(viewModel::tryAgain)
            }

            UiStatus.Ready -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp,
                        ),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(uiState.accounts) { account ->
                        AccountItem(
                            account = account,
                            onClick = {}
                        )
                    }
                }
            }
        }
    }
}
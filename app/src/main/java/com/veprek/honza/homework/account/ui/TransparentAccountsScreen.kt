package com.veprek.honza.homework.account.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.veprek.honza.homework.R
import com.veprek.honza.homework.account.presentation.TransparentAccountsViewModel
import com.veprek.honza.homework.core.presentation.UiStatus
import com.veprek.honza.homework.design.ui.screen.ErrorScreen
import com.veprek.honza.homework.design.ui.screen.LoadingScreen
import com.veprek.honza.homework.design.ui.theme.HomeworkTheme
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TransparentAccountsScreen(
    viewModel: TransparentAccountsViewModel = koinViewModel(),
    onAccountClick: (String) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.transparent_accounts),
                    )
                },
            )
        }
    ) { paddingValues ->
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
                        .padding(all = HomeworkTheme.dimensions.spacingMedium),
                    contentPadding = PaddingValues(vertical = HomeworkTheme.dimensions.spacingMedium),
                    verticalArrangement = Arrangement.spacedBy(HomeworkTheme.dimensions.spacingLarge)
                ) {
                    items(uiState.accounts) { account ->
                        AccountItem(
                            account = account,
                            onClick = { onAccountClick(account.accountNumber) }
                        )
                    }
                }
            }
        }
    }
}
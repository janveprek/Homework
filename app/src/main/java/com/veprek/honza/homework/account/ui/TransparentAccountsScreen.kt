package com.veprek.honza.homework.account.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.veprek.honza.homework.account.presentation.TransparentAccountsViewModel
import com.veprek.honza.homework.core.presentation.UiStatus
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun TransparentAccountsScreen(
    viewModel: TransparentAccountsViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold { paddingValues ->
        when (uiState.uiStatus) {
            // TODO: Add loading and error screens
            UiStatus.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            UiStatus.Error -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Error loading accounts",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }

            UiStatus.Ready -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(horizontal = 16.dp,
                        ),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(uiState.accounts) { account ->
                        AccountItem(
                            account = account,
                            onClick = {
                            }
                        )
                    }
                }
            }
        }
    }
}
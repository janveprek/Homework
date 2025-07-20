package com.veprek.honza.homework.accountdetail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.veprek.honza.homework.R
import com.veprek.honza.homework.accountdetail.presentation.TransparentAccountDetailViewModel
import com.veprek.honza.homework.core.presentation.UiStatus
import com.veprek.honza.homework.design.ui.screen.ErrorScreen
import com.veprek.honza.homework.design.ui.screen.LoadingScreen
import com.veprek.honza.homework.design.ui.theme.HomeworkTheme
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TransparentAccountDetailScreen(
    navigateUp: () -> Unit,
    viewModel: TransparentAccountDetailViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = uiState.account.name,
                    )
                },
                navigationIcon = {
                        IconButton(onClick = navigateUp) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null
                            )
                        }
                }
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
                        .padding(horizontal = HomeworkTheme.dimensions.spacingLarge),
                    contentPadding = PaddingValues(vertical = HomeworkTheme.dimensions.spacingSmall),
                    verticalArrangement = Arrangement.spacedBy(HomeworkTheme.dimensions.spacingLarge)
                ) {
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .shadow(elevation = HomeworkTheme.dimensions.shadowHeight)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(HomeworkTheme.dimensions.spacingExtraLarge),
                                verticalArrangement = Arrangement.spacedBy(HomeworkTheme.dimensions.spacingLarge)
                            ) {
                                DetailRow(
                                    label = stringResource(R.string.detail_account_number),
                                    value = uiState.account.accountNumber
                                )

                                DetailRow(
                                    label = stringResource(R.string.detail_iban),
                                    value = uiState.account.iban
                                )

                                DetailRow(
                                    label = stringResource(R.string.detail_balance),
                                    value = uiState.account.balance
                                )

                                DetailRow(
                                    label = stringResource(R.string.detail_actualization_date),
                                    value = uiState.account.actualizationDate
                                )
                            }
                        }
                    }

                    item {
                        Text(
                            style = MaterialTheme.typography.titleMedium,
                            text = stringResource(R.string.detail_transactions)
                        )
                    }

                    items(uiState.transactions) { transaction ->
                        TransactionItem(
                            transaction = transaction,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun DetailRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f)
        )
    }
}
package com.veprek.honza.homework.accountdetail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.veprek.honza.homework.R
import com.veprek.honza.homework.accountdetail.presentation.state.TransactionState
import com.veprek.honza.homework.design.ui.theme.HomeworkTheme

@Composable
internal fun TransactionItem(
    transaction: TransactionState,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(HomeworkTheme.dimensions.spacingSmall)
            .shadow(elevation = HomeworkTheme.dimensions.shadowHeight),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(HomeworkTheme.dimensions.spacingMedium),
            verticalArrangement = Arrangement.spacedBy(HomeworkTheme.dimensions.spacingSmall)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = transaction.typeDescription,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = transaction.amount,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            transaction.processingDate?.let { date ->
                Text(
                    text = date,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(HomeworkTheme.dimensions.spacingLarge)
            ) {
                transaction.senderAccountNumber?.let { accountNumber ->
                    AccountHolder(
                        label = stringResource(R.string.from),
                        accountNumber = accountNumber,
                        name = transaction.senderName,
                        description = transaction.senderDescription,
                        modifier = Modifier.weight(1f)
                    )
                }
                transaction.receiverAccountNumber?.let { accountNumber ->
                    AccountHolder(
                        label = stringResource(R.string.to),
                        accountNumber = accountNumber,
                        name = transaction.receiverName,
                        description = transaction.receiverDescription,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

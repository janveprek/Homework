package com.veprek.honza.homework.core.system

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.veprek.honza.homework.account.ui.TransparentAccountsScreen
import com.veprek.honza.homework.accountdetail.ui.TransparentAccountDetailScreen
import com.veprek.honza.homework.core.model.Screen

@Composable
internal fun Navigation(
    navController: NavHostController,
    startDestination: Screen,
    modifier: Modifier = Modifier,
) {
    val navigateUp: () -> Unit = { navController.navigateUp() }

    val navigateToAccountDetail = { code: String ->
        navController.navigate(Screen.AccountDetail(code))
    }
    NavHost(modifier = modifier, navController = navController, startDestination = startDestination) {
        composable<Screen.AccountsList> {
            TransparentAccountsScreen(
                onAccountClick = navigateToAccountDetail
            )
        }
        composable<Screen.AccountDetail> {
            TransparentAccountDetailScreen(navigateUp = navigateUp)
        }
    }
}
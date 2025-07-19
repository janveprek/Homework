package com.veprek.honza.homework.account.di

import com.veprek.honza.homework.account.data.AccountApi
import com.veprek.honza.homework.account.data.RemoteAccountRepository
import com.veprek.honza.homework.account.domain.GetTransparentAccountsUseCase
import com.veprek.honza.homework.account.domain.GetTransparentAccountsUseCaseImpl
import com.veprek.honza.homework.account.domain.AccountRepository
import com.veprek.honza.homework.account.presentation.TransparentAccountsViewModel
import com.veprek.honza.homework.account.system.RemoteAccountApi
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val accountModule = module {
    singleOf(::RemoteAccountApi) {
        bind<AccountApi>()
    }
    singleOf(::RemoteAccountRepository) {
        bind<AccountRepository>()
    }
    singleOf(::GetTransparentAccountsUseCaseImpl) {
        bind<GetTransparentAccountsUseCase>()
    }
    viewModel { TransparentAccountsViewModel(get()) }
}
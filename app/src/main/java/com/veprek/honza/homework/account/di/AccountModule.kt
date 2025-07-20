package com.veprek.honza.homework.account.di

import com.veprek.honza.homework.account.data.AccountApi
import com.veprek.honza.homework.account.data.RemoteAccountRepository
import com.veprek.honza.homework.account.domain.AccountRepository
import com.veprek.honza.homework.accountdetail.domain.GetTransparentAccountDetailUseCase
import com.veprek.honza.homework.accountdetail.domain.GetTransparentAccountDetailUseCaseImpl
import com.veprek.honza.homework.account.domain.GetTransparentAccountsUseCase
import com.veprek.honza.homework.account.domain.GetTransparentAccountsUseCaseImpl
import com.veprek.honza.homework.account.presentation.TransparentAccountsViewModel
import com.veprek.honza.homework.account.system.RemoteAccountApi
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val accountModule = module {
    singleOf(::RemoteAccountApi) {
        bind<AccountApi>()
    }
    singleOf(::RemoteAccountRepository) {
        bind<AccountRepository>()
    }
    factoryOf(::GetTransparentAccountsUseCaseImpl) {
        bind<GetTransparentAccountsUseCase>()
    }
    factoryOf(::GetTransparentAccountDetailUseCaseImpl) {
        bind<GetTransparentAccountDetailUseCase>()
    }
    viewModelOf(::TransparentAccountsViewModel)
}
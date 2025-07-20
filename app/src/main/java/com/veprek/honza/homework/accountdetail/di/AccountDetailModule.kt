package com.veprek.honza.homework.accountdetail.di

import com.veprek.honza.homework.accountdetail.domain.GetTransactionsForAccountUseCase
import com.veprek.honza.homework.accountdetail.domain.GetTransactionsForAccountUseCaseImpl
import com.veprek.honza.homework.accountdetail.domain.GetTransparentAccountDetailUseCase
import com.veprek.honza.homework.accountdetail.domain.GetTransparentAccountDetailUseCaseImpl
import com.veprek.honza.homework.accountdetail.presentation.TransparentAccountDetailViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val accountDetailModule = module {
    factoryOf(::GetTransactionsForAccountUseCaseImpl) {
        bind<GetTransactionsForAccountUseCase>()
    }
    factoryOf(::GetTransparentAccountDetailUseCaseImpl) {
        bind<GetTransparentAccountDetailUseCase>()
    }
    viewModelOf(::TransparentAccountDetailViewModel)
}
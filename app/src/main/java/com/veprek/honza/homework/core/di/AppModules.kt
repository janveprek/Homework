package com.veprek.honza.homework.core.di

import com.veprek.honza.homework.account.di.accountModule
import com.veprek.honza.homework.accountdetail.di.accountDetailModule
import com.veprek.honza.homework.networking.di.networkingModule

val appModules = listOf(
    accountModule,
    accountDetailModule,
    networkingModule
)
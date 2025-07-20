package com.veprek.honza.homework.account.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class TransparentAccountsResponseDto(
    @SerialName("pageNumber")
    val pageNumber: Int,
    @SerialName("pageSize")
    val pageSize: Int,
    @SerialName("pageCount")
    val pageCount: Int,
    @SerialName("nextPage")
    val nextPage: Int?,
    @SerialName("recordCount")
    val recordCount: Int,
    @SerialName("accounts")
    val accounts: List<TransparentAccountDto>
)

@Serializable
internal data class TransparentAccountDto(
    @SerialName("accountNumber")
    val accountNumber: String,
    @SerialName("bankCode")
    val bankCode: String? = null,
    @SerialName("transparencyFrom")
    val transparencyFrom: String? = null,
    @SerialName("transparencyTo")
    val transparencyTo: String? = null,
    @SerialName("publicationTo")
    val publicationTo: String? = null,
    @SerialName("actualizationDate")
    val actualizationDate: String? = null,
    @SerialName("balance")
    val balance: Double? = null,
    @SerialName("currency")
    val currency: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("iban")
    val iban: String? = null,
)
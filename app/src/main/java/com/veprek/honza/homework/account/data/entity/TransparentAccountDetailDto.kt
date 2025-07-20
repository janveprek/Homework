package com.veprek.honza.homework.account.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class TransparentAccountDetailDto(
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
    @SerialName("description")
    val description: String? = null,
    @SerialName("iban")
    val iban: String? = null,
)

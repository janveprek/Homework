package com.veprek.honza.homework.core.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

sealed interface DataResult<out T> {
    companion object {
        fun <T> success(data: T): DataResult<T> = Success(data)
        fun <T> error(cause: Throwable): DataResult<T> = GeneralError(cause)
    }
}

data class Success<out T> internal constructor(
    val data: T,
) : DataResult<T>

data class GeneralError internal constructor(
    override val error: Throwable,
) : Error

sealed interface Error : DataResult<Nothing> {
    val error: Throwable
}

@Suppress("TooGenericExceptionCaught")
suspend fun <T> apiDataResult(block: suspend () -> T): DataResult<T> = withContext(Dispatchers.IO) {
    try {
        val data = block()
        DataResult.success(data)
    } catch (ex: Exception) {
        DataResult.error(ex)
    }
}
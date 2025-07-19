package com.veprek.honza.homework.core.model

inline fun <T> DataResult<T>.handle(
    onSuccess: (success: Success<T>) -> Unit = {},
    onError: (error: Error) -> Unit = {},
): DataResult<T> {
    when (this) {
        is Success -> onSuccess(this)
        is GeneralError -> {
            onError(this)
        }
    }
    return this
}

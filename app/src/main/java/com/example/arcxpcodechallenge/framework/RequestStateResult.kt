package com.example.arcxpcodechallenge.framework

sealed class RequestStateResult<out T> {
    data class Success<out T>(val data: T) : RequestStateResult<T>()
    data class Error(val exception: DataSourceException) : RequestStateResult<Nothing>()
    object Loading : RequestStateResult<Nothing>()
    object NoInternet : RequestStateResult<Nothing>()
}

inline fun <T : Any> RequestStateResult<T?>.onSuccess(action: (T?) -> Unit): RequestStateResult<T?> {
    if (this is RequestStateResult.Success) action(data)
    return this
}

inline fun <T : Any> RequestStateResult<T?>.onError(action: (DataSourceException) -> Unit): RequestStateResult<T?> {
    if (this is RequestStateResult.Error) action(exception)
    return this
}

inline fun <T : Any> RequestStateResult<T?>.onLoading(action: () -> Unit): RequestStateResult<T?> {
    if (this is RequestStateResult.Loading) action()
    return this
}

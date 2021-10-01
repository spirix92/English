package com.selen.english.data

/**
 * @author Pyaterko Aleksey
 */
sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

val Result<*>.succeeded
    get() = this is Result.Success && data != null

val Result<*>.failed
    get() = this is Result.Error

fun <T> Result<T>.getOrNull(): T? {
    return if (this.succeeded) (this as Result.Success<T>).data else null
}

fun <T> Result<T>.getOrElse(elseValue: T): T {
    return if (this.succeeded) (this as Result.Success<T>).data else elseValue
}

fun Result<*>.exceptionOrNull(): Throwable? {
    return if (this.failed) (this as Result.Error).exception else null
}

fun Result<*>.exceptionOrElse(throwable: Throwable): Throwable {
    return if (this.failed) (this as Result.Error).exception else throwable
}
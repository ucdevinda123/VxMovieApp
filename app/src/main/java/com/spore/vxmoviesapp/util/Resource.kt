package com.spore.vxmoviesapp.util

sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val error: String) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}

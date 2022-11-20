package com.dellosaneil.pokedex_mobile.network.pagination

interface PaginationStateHelper {
    fun loading(isInitialLoad: Boolean,) : PaginationState
    fun error(isInitialLoad: Boolean, throwable: Throwable,) : PaginationState
    fun success(isInitialLoad: Boolean,) : PaginationState
}

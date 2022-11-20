package com.dellosaneil.pokedex_mobile.network.pagination.impl

import com.dellosaneil.pokedex_mobile.network.pagination.PaginationState
import com.dellosaneil.pokedex_mobile.network.pagination.PaginationStateHelper

class PaginationStateHelperImpl : PaginationStateHelper {
    override fun loading(isInitialLoad: Boolean): PaginationState {
        return PaginationState(
            isInitialLoad = isInitialLoad,
            isLoadMore = !isInitialLoad,
            loadMoreError = null,
            initialLoadError = null,
        )
    }

    override fun error(isInitialLoad: Boolean, throwable: Throwable): PaginationState {
        return PaginationState(
            isLoadMore = false,
            isInitialLoad = false,
            loadMoreError = if (isInitialLoad) null else throwable,
            initialLoadError = if (isInitialLoad) throwable else null,
        )
    }

    override fun success(isInitialLoad: Boolean): PaginationState {
        return PaginationState(
            isLoadMore = false,
            isInitialLoad = false,
            loadMoreError = null,
            initialLoadError = null,
        )
    }


}

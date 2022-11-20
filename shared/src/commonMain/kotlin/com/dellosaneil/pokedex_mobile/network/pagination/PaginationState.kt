package com.dellosaneil.pokedex_mobile.network.pagination

data class PaginationState(
    val isInitialLoad: Boolean,
    val isLoadMore: Boolean,
    val initialLoadError: Throwable?,
    val loadMoreError: Throwable?,
) {
    companion object {
        fun initialState() : PaginationState {
            return PaginationState(
                isInitialLoad = true,
                isLoadMore = false,
                initialLoadError = null,
                loadMoreError = null,
            )
        }
    }
}

package com.nicequest.nicequesttest.presentation.presenters

import com.nicequest.nicequesttest.domain.model.ItemCat

interface DashboardPresenterInterface {
    fun loadMoreItems(page: Int)
    fun loadMoreItemsSuccess(list: List<ItemCat>)
    fun subscribe(page: Int)
    fun unsubscribe()
}
package com.nicequest.nicequesttest.presentation.presenters

import com.nicequest.nicequesttest.domain.model.ItemCat

interface DashboardFragmentPresenterInterface{
    fun loadMoreItems(page: Int)
    fun loadMoreItemsSuccess(list: List<ItemCat>)
    fun subscribe(page: Int)
    fun unsubscribe()
}
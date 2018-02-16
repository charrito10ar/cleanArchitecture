package com.nicequest.nicequesttest.presentation.ui

import com.nicequest.nicequesttest.domain.model.ItemCat


interface DashboardFragmentView{
    fun showList(list: List<ItemCat>)
    fun setupList()
    fun showMessageError(message: String)
    fun showMessage(message: String)
    fun showLoading()
    fun hideLoading()
}

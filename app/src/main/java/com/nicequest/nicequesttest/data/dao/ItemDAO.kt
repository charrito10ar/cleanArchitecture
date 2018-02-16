package com.nicequest.nicequesttest.data.dao

interface ItemDAO {

    fun loadDashboardItems(mListener: ItemDaoImpl.ItemDAOListener)
}
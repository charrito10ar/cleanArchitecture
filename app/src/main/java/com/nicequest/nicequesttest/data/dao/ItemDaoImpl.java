package com.nicequest.nicequesttest.data.dao;


import com.nicequest.nicequesttest.data.network.CatsRestAdapter;
import com.nicequest.nicequesttest.data.network.bodies.ResponseImgur;

import java.util.List;

import javax.inject.Inject;

public class ItemDaoImpl implements ItemDAO {

    CatsRestAdapter catsRestAdapter;

    @Inject
    public ItemDaoImpl(CatsRestAdapter catsRestAdapter){
        this.catsRestAdapter = catsRestAdapter;
    }

    @Override
    public void loadDashboardItems(ItemDAOListener mListener) {

    }

    public interface ItemDAOListener{
        void getDashboardItemsSuccessful(ResponseImgur responseImgur);
        void getDashboardItemsError(Throwable throwable);
    }
}

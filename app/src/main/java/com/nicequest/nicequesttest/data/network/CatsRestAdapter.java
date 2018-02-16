package com.nicequest.nicequesttest.data.network;

import com.marcelo.privalia.moviesapp.data.network.interfaces.RetrofitImageService;
import com.nicequest.nicequesttest.data.network.bodies.ResponseImgur;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class CatsRestAdapter {
    private RetrofitImageService mApi;

    @Inject
    public CatsRestAdapter(Retrofit retrofit){
        mApi = retrofit.create(RetrofitImageService.class);
    }

    public Observable<ResponseImgur> getDashboardItemsRX(int page){
        return mApi.getItemCats(page);
    }
}

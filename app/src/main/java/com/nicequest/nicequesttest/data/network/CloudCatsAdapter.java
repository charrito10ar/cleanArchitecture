package com.nicequest.nicequesttest.data.network;

import com.marcelo.privalia.moviesapp.data.network.interfaces.ImgurApiService;
import com.nicequest.nicequesttest.data.network.bodies.ResponseImgur;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class CloudCatsAdapter {
    private ImgurApiService mApi;

    @Inject
    public CloudCatsAdapter(Retrofit retrofit){
        mApi = retrofit.create(ImgurApiService.class);
    }

    public Observable<ResponseImgur> getByPage(int page){
        return mApi.getCatsByPage(page);
    }
}

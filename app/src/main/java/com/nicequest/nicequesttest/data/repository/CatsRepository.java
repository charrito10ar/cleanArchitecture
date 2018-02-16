package com.nicequest.nicequesttest.data.repository;

import com.nicequest.nicequesttest.data.network.ApiService;
import com.nicequest.nicequesttest.data.network.bodies.ResponseImgur;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class CatsRepository implements Repository{

    @Override
    public Observable<ResponseImgur> getTopCats(int page) {
        return ApiService.getApiEndPoint().getImages(page);
    }
}

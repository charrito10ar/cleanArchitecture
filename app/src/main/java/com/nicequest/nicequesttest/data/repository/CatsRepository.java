package com.nicequest.nicequesttest.data.repository;

import com.nicequest.nicequesttest.data.network.CloudCatsAdapter;
import com.nicequest.nicequesttest.data.network.bodies.ResponseImgur;

import javax.inject.Inject;
import io.reactivex.Observable;

public class CatsRepository implements Repository{

    private CloudCatsAdapter cloudCatsAdapter;

    @Inject
    public CatsRepository(CloudCatsAdapter catsRestAdapter){
        cloudCatsAdapter = catsRestAdapter;
    }

    @Override
    public Observable<ResponseImgur> getByPage(int page) {
        return cloudCatsAdapter.getByPage(page);
    }
}

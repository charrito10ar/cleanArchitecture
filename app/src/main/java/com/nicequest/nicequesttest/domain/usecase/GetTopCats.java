package com.nicequest.nicequesttest.domain.usecase;


import com.nicequest.nicequesttest.data.network.bodies.ResponseImgur;
import com.nicequest.nicequesttest.data.repository.Repository;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class GetTopCats {
    private final Repository repository;

    @Inject
    public GetTopCats(Repository repository) {
        super();
        this.repository = repository;
    }


    public Observable<ResponseImgur> createObservableUseCase(int page){
        return this.repository.getTopCats(page);

    }

}

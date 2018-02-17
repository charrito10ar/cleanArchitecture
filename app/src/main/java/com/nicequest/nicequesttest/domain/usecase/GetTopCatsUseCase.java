package com.nicequest.nicequesttest.domain.usecase;


import com.nicequest.nicequesttest.data.network.bodies.ResponseImgur;
import com.nicequest.nicequesttest.data.repository.Repository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This use case use a generic repository. Then it is easy to change the implementation
 * of the repository and get data from the another source
 */
public class GetTopCatsUseCase implements UseCase<ResponseImgur>{
    private final Repository repository;

    @Inject
    public GetTopCatsUseCase(Repository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Observable<ResponseImgur> getByPage(int page){
        return this.repository.getByPage(page);

    }

}

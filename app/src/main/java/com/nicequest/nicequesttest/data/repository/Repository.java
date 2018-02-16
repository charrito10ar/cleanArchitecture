package com.nicequest.nicequesttest.data.repository;

import com.nicequest.nicequesttest.data.network.bodies.ResponseImgur;

import io.reactivex.Observable;


public interface Repository {
    Observable<ResponseImgur> getTopCats(int page);
}
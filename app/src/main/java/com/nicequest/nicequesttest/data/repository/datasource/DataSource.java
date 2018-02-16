package com.nicequest.nicequesttest.data.repository.datasource;


import com.nicequest.nicequesttest.data.network.bodies.ResponseImgur;

import io.reactivex.Observable;

public interface DataSource {
    Observable<ResponseImgur> teamEntityList();
}

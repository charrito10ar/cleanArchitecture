package com.marcelo.privalia.moviesapp.data.network.interfaces

import com.nicequest.nicequesttest.data.network.bodies.ResponseImgur
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ImgurApiService {

    @GET("/3/gallery/t/cats/{pageNumber}")
    fun getCatsByPage(@Path("pageNumber") pageNumber: Int): Observable<ResponseImgur>

}
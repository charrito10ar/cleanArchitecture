package com.nicequest.nicequesttest.data.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.marcelo.privalia.moviesapp.data.network.interfaces.RetrofitImageService;
import com.nicequest.nicequesttest.data.network.bodies.ResponseImgur;

import org.json.JSONObject;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MetaApiEndPoint {

    private RetrofitImageService mApi;

    public MetaApiEndPoint(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.authenticator(new RetrofitAuthenticator());
        builder.addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                    .addHeader("Authorization", "Client-ID f17d2424d09ef1c").build();
            return chain.proceed(request);
        });

        OkHttpClient okHttpClient = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(OAuthInterface.endPoint)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApi = retrofit.create(RetrofitImageService.class);
    }

    public Observable<ResponseImgur> getImages(int page){
        return mApi.getItemCats(page);
    }


}
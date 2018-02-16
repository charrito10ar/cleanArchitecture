package com.nicequest.nicequesttest.di.modules;

import android.app.Application;
import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.nicequest.nicequesttest.data.network.RetrofitAuthenticator;
import com.nicequest.nicequesttest.presentation.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    private final BaseApplication application;

    public ApplicationModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application application() {
        return application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    Retrofit networkManager() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.authenticator(new RetrofitAuthenticator());
        builder.addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                    .addHeader("Authorization", "Client-ID f17d2424d09ef1c").build();
            return chain.proceed(request);
        });

        OkHttpClient okHttpClient = builder.build();

        return new Retrofit.Builder()
                .baseUrl("https://api.imgur.com/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}

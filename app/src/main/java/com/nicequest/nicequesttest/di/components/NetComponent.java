package com.nicequest.nicequesttest.di.components;

import com.nicequest.nicequesttest.di.modules.ApplicationModule;
import com.nicequest.nicequesttest.di.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules={ApplicationModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
}
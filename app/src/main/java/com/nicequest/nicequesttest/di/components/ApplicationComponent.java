package com.nicequest.nicequesttest.di.components;

import android.app.Application;
import android.content.Context;

import com.nicequest.nicequesttest.data.repository.Repository;
import com.nicequest.nicequesttest.presentation.BaseApplication;
import com.nicequest.nicequesttest.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseApplication application);
    void inject(Repository repository);
    Application application();
    Context context();
//    Retrofit getRetrofit();
}
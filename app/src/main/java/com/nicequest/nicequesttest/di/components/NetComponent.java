package com.nicequest.nicequesttest.di.components;

import android.app.Activity;

import com.nicequest.nicequesttest.di.modules.ApplicationModule;
import com.nicequest.nicequesttest.di.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface NetComponent {
    void inject(Activity activity);
    // void inject(MyFragment fragment);
    // void inject(MyService service);
}
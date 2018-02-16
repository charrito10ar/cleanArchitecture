package com.nicequest.nicequesttest.presentation;

import android.app.Application;
import android.content.Context;

import com.nicequest.nicequesttest.di.components.ApplicationComponent;
import com.nicequest.nicequesttest.di.components.DaggerApplicationComponent;
import com.nicequest.nicequesttest.di.modules.ApplicationModule;

public class BaseApplication extends Application {

    private ApplicationComponent component;

    public static BaseApplication get(Context context) {
        return (BaseApplication) context.getApplicationContext();
    }

    @Override public void onCreate() {
        super.onCreate();
        setupGraph();
    }

    public void setupGraph() {
        component = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        component.inject(this);
    }

    public ApplicationComponent component() {
        return component;
    }
}
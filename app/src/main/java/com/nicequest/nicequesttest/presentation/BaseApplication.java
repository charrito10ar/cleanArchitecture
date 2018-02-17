package com.nicequest.nicequesttest.presentation;

import android.app.Application;
import android.content.Context;

import com.nicequest.nicequesttest.di.components.ApplicationComponent;
import com.nicequest.nicequesttest.di.components.DaggerApplicationComponent;
import com.nicequest.nicequesttest.di.components.DaggerNetComponent;
import com.nicequest.nicequesttest.di.components.NetComponent;
import com.nicequest.nicequesttest.di.modules.ApplicationModule;

public class BaseApplication extends Application {

    private ApplicationComponent component;
    private NetComponent mNetComponent;
    private static BaseApplication app;

    public static BaseApplication get(Context context) {
        return (BaseApplication) context.getApplicationContext();
    }

    public static BaseApplication getApp() {
        return app;
    }

    @Override public void onCreate() {
        super.onCreate();
        app = this;
        setupGraph();
    }

    public void setupGraph() {
        component = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        component.inject(this);
        mNetComponent = DaggerNetComponent.create();
    }

    public ApplicationComponent component() {
        return component;
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
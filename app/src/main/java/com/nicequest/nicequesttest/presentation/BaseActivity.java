package com.nicequest.nicequesttest.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nicequest.nicequesttest.di.components.ApplicationComponent;


public abstract class BaseActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(BaseApplication.get(this).component());
    }

    protected abstract void setupComponent(ApplicationComponent appComponent);
}
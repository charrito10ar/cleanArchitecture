package com.nicequest.nicequesttest.di.components;

import com.nicequest.nicequesttest.data.repository.CatsRepository;
import com.nicequest.nicequesttest.presentation.DashboardActivity;
import com.nicequest.nicequesttest.presentation.adapters.CatAdapter;
import com.nicequest.nicequesttest.di.ActivityScope;
import com.nicequest.nicequesttest.di.modules.DashboardModule;
import com.nicequest.nicequesttest.presentation.presenters.DashboardFragmentPresenter;

import dagger.Component;

@ActivityScope
@Component(modules = {
        DashboardModule.class,
})
public interface DashboardComponent {

    void inject(DashboardActivity dashboardFragment);
    CatAdapter getDashboardAdapter();
    DashboardFragmentPresenter getPresenter();
    //CatsRepository getCatReposotory();
}

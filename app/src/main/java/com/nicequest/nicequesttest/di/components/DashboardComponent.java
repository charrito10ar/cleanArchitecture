package com.nicequest.nicequesttest.di.components;

import com.nicequest.nicequesttest.data.network.CloudCatsAdapter;
import com.nicequest.nicequesttest.data.repository.CatsRepository;
import com.nicequest.nicequesttest.domain.usecase.GetTopCatsUseCase;
import com.nicequest.nicequesttest.presentation.ui.DashboardActivity;
import com.nicequest.nicequesttest.presentation.adapters.CatAdapter;
import com.nicequest.nicequesttest.di.ActivityScope;
import com.nicequest.nicequesttest.di.modules.DashboardModule;
import com.nicequest.nicequesttest.presentation.presenters.DashboardPresenter;
import com.nicequest.nicequesttest.presentation.ui.DashboardView;

import dagger.Component;

@ActivityScope
@Component(modules = {
        DashboardModule.class,
})
public interface DashboardComponent {

    void inject(DashboardActivity dashboardFragment);
    DashboardView getDashboardView();
    CatAdapter getDashboardAdapter();
    DashboardPresenter getPresenter();
    CatsRepository getCatReposotory();
    GetTopCatsUseCase getTopCats();
    CloudCatsAdapter getCloudCatsAdapter();
}

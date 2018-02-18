package com.nicequest.nicequesttest.di.modules;

import android.content.Context;

import com.nicequest.nicequesttest.data.network.CloudCatsAdapter;
import com.nicequest.nicequesttest.data.network.bodies.ResponseImgur;
import com.nicequest.nicequesttest.data.repository.CatsRepository;
import com.nicequest.nicequesttest.data.repository.Repository;
import com.nicequest.nicequesttest.domain.usecase.GetTopCatsUseCase;
import com.nicequest.nicequesttest.domain.usecase.UseCase;
import com.nicequest.nicequesttest.presentation.BaseApplication;
import com.nicequest.nicequesttest.presentation.adapters.CatAdapter;
import com.nicequest.nicequesttest.di.ActivityScope;
import com.nicequest.nicequesttest.presentation.presenters.DashboardPresenter;
import com.nicequest.nicequesttest.presentation.presenters.DashboardPresenterInterface;
import com.nicequest.nicequesttest.presentation.ui.DashboardView;

import dagger.Module;
import dagger.Provides;

@Module
public class DashboardModule {
    private DashboardView view;
    private final Context context;

    public DashboardModule(DashboardView view, Context context){
        this.view = view;
        this.context = context;
    }

    @Provides
    @ActivityScope
    public CatAdapter provideItemDashboardAdapter(){
        return new CatAdapter(context);
    }

    @Provides
    @ActivityScope
    public DashboardView provideView(){
        return view;
    }

    @Provides
    @ActivityScope
    public DashboardPresenterInterface providePresenter(DashboardView view, GetTopCatsUseCase getTopCats){
        return new DashboardPresenter(view, getTopCats);
    }

    @Provides
    @ActivityScope
    public UseCase<ResponseImgur> provideGetTopCats(Repository repository){
        return new GetTopCatsUseCase(repository);
    }

    @Provides
    @ActivityScope
    public Repository provideCatRepository(CloudCatsAdapter cloudCatsAdapter){
        return new CatsRepository(cloudCatsAdapter);
    }

    @Provides
    @ActivityScope
    public CloudCatsAdapter provideCloudCatsAdapter(){
        return new CloudCatsAdapter(BaseApplication.getApp().getNetComponent().retrofit());
    }


}

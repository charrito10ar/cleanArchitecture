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
import com.nicequest.nicequesttest.presentation.presenters.DashboardFragmentPresenter;
import com.nicequest.nicequesttest.presentation.ui.DashboardFragmentView;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class DashboardModule {
    private DashboardFragmentView view;
    private final Context context;

    public DashboardModule(DashboardFragmentView view, Context context){
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
    public DashboardFragmentView provideView(){
        return view;
    }

    @Provides
    @ActivityScope
    public DashboardFragmentPresenter providePresenter(DashboardFragmentView view, GetTopCatsUseCase getTopCats){
        return new DashboardFragmentPresenter(view, getTopCats);
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

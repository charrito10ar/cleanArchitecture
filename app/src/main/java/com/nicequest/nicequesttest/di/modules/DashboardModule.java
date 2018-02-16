package com.nicequest.nicequesttest.di.modules;

import android.content.Context;

import com.nicequest.nicequesttest.data.repository.CatsRepository;
import com.nicequest.nicequesttest.data.repository.Repository;
import com.nicequest.nicequesttest.domain.usecase.GetTopCats;
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
        return new CatAdapter(new ArrayList<>(), context);
    }

    @Provides
    @ActivityScope
    public DashboardFragmentView provideView(){
        return view;
    }

    @Provides
    @ActivityScope
    public DashboardFragmentPresenter providePresenter(DashboardFragmentView view){
        return new DashboardFragmentPresenter(view, new GetTopCats(new CatsRepository()));
    }

//    @Provides
//    @ActivityScope
//    public Repository provideCatRepository(){
//        return new CatsRepository();
//    }

}

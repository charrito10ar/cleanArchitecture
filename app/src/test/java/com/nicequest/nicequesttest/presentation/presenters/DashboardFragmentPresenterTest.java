package com.nicequest.nicequesttest.presentation.presenters;


import com.nicequest.nicequesttest.domain.model.ItemCat;
import com.nicequest.nicequesttest.presentation.ui.DashboardFragmentView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

@RunWith(MockitoJUnitRunner.class)
public class DashboardFragmentPresenterTest {

    @Mock
    DashboardFragmentView view;

    @Mock
    List<ItemCat> itemCatEntityList;

    DashboardFragmentPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new DashboardFragmentPresenter(view);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    @Test
    public void loadMoreAndShowLoadingTest() throws Exception {
        presenter.loadMoreItems(1);
        verify(view).showLoading();
    }

    @Test
    public void loadMoreItemsSuccessTest() throws Exception{
        presenter.loadMoreItemsSuccess(itemCatEntityList);
        verify(view).showList(itemCatEntityList);
        verify(view).hideLoading();
    }

}
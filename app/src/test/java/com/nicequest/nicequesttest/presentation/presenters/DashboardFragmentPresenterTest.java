package com.nicequest.nicequesttest.presentation.presenters;


import com.nicequest.nicequesttest.data.network.bodies.Data;
import com.nicequest.nicequesttest.data.network.bodies.ResponseImgur;
import com.nicequest.nicequesttest.domain.model.ItemCat;
import com.nicequest.nicequesttest.domain.usecase.GetTopCatsUseCase;
import com.nicequest.nicequesttest.presentation.ui.DashboardView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

@RunWith(MockitoJUnitRunner.class)
public class DashboardFragmentPresenterTest {

    @Mock
    private DashboardView viewMock;
    @Mock
    private GetTopCatsUseCase topCatsUseCaseMock;
    @Mock
    private List<ItemCat> itemCatEntityListMock;
    DashboardPresenter presenter;
    private Data data;

    @Before
    public void setUp() throws Exception {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
        presenter = new DashboardPresenter(viewMock, topCatsUseCaseMock);
        data = new Data("title", new ArrayList<>());
    }

    @Test
    public void loadMoreAndShowLoadingTest() throws Exception {
        when(topCatsUseCaseMock.getByPage(1)).thenReturn(Observable.just(new ResponseImgur(data, true, 200 )));
        presenter.loadMoreItems(1);
        verify(viewMock).showLoading();
    }

    @Test
    public void loadMoreItemsSuccessTest() throws Exception{
        presenter.loadMoreItemsSuccess(itemCatEntityListMock);
        verify(viewMock).showList(itemCatEntityListMock);
        verify(viewMock).hideLoading();
    }
}
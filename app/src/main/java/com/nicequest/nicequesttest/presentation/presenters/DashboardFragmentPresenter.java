package com.nicequest.nicequesttest.presentation.presenters;

import com.nicequest.nicequesttest.data.network.bodies.ResponseImgur;
import com.nicequest.nicequesttest.domain.mappers.MapperCats;
import com.nicequest.nicequesttest.domain.model.ItemCat;
import com.nicequest.nicequesttest.domain.usecase.GetTopCatsUseCase;
import com.nicequest.nicequesttest.domain.usecase.UseCase;
import com.nicequest.nicequesttest.presentation.ui.DashboardFragmentView;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DashboardFragmentPresenter implements DashboardFragmentPresenterInterface{

    private DashboardFragmentView view;
    private Disposable mSubscription;
    private UseCase<ResponseImgur> useCaseGetTopCats;

    @Inject
    public DashboardFragmentPresenter(DashboardFragmentView view, GetTopCatsUseCase getTopCats){
        this.view = view;
        this.useCaseGetTopCats = getTopCats;
    }

    @Override
    public void loadMoreItems(int page) {
        view.showLoading();
        mSubscription = useCaseGetTopCats.getByPage(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( responseBody -> {
                    MapperCats mapper = new MapperCats();
                    loadMoreItemsSuccess(mapper.map(responseBody));
                }, error -> view.showMessageError(error.getMessage()));
    }

    @Override
    public void loadMoreItemsSuccess(@NotNull List<ItemCat> list) {
        view.showList(list);
        view.hideLoading();
    }

    @Override
    public void subscribe(int page) {
        loadMoreItems(page);
    }

    @Override
    public void unsubscribe() {
        if (mSubscription != null && mSubscription.isDisposed())
            mSubscription.dispose();
    }
}
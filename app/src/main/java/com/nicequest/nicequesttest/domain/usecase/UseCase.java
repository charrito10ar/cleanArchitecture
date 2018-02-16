package com.nicequest.nicequesttest.domain.usecase;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

abstract class UseCase<T> {
    protected abstract Observable<T> createObservableUseCase();
}

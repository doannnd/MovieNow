package com.example.movienow.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * doannd
 *
 * base rx presenter
 * @param <T> view
 */
public class RxPresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {

    protected T view;
    private CompositeDisposable compositeDisposable;

    private void unSubscribe() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }

    protected void addSubcribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
        unSubscribe();
    }
}

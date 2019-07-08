package com.example.movienow.ui.list.presenter;

import com.example.movienow.base.RxPresenter;
import com.example.movienow.data.DataManager;
import com.example.movienow.ui.list.contract.MovieListContract;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * doannd
 *
 * movie list presenter
 */
public class MovieListPresenter extends RxPresenter<MovieListContract.View>
        implements MovieListContract.Presenter<MovieListContract.View> {

    private DataManager dataManager;

    @Inject
    MovieListPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getPopularMovies(String apiKey) {
        Disposable disposable = dataManager.getPopularMovies(apiKey)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .flatMap(response -> Observable.just(response.getResults()))
                .subscribe(
                        (beans) -> view.showPopularMovies(beans),
                        (error) -> view.showError()
                );
        addSubcribe(disposable);
    }
}

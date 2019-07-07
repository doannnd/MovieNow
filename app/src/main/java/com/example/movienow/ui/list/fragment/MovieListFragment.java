package com.example.movienow.ui.list.fragment;

import com.example.movienow.BuildConfig;
import com.example.movienow.R;
import com.example.movienow.base.BaseFragment;
import com.example.movienow.data.model.Movie;
import com.example.movienow.ui.list.contract.MovieListContract;
import com.example.movienow.ui.list.presenter.MovieListPresenter;
import com.orhanobut.logger.Logger;

import java.util.List;

import javax.inject.Inject;

/**
 * doannd
 *
 * movie list fragment
 */
public class MovieListFragment extends BaseFragment implements MovieListContract.View {

    @Inject
    MovieListPresenter presenter;

    @Override
    protected void setupComponent() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void attachView() {
        presenter.attachView(this);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void configViews() {
        presenter.getPopularMovies(BuildConfig.API_KEY);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie_list;
    }

    @Override
    public void showPopularMovies(List<Movie> movieList) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onDestroyView() {
        presenter.detachView();
        super.onDestroyView();
    }
}

package com.example.movienow.ui.list.contract;

import com.example.movienow.base.BaseContract;
import com.example.movienow.data.model.Movie;
import com.example.movienow.data.model.Response;

import java.util.List;

/**
 * doannd
 *
 * Movie list contract
 */
public interface MovieListContract {
    interface View extends BaseContract.BaseView {
        void showPopularMovies(List<Movie> movieList);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getPopularMovies(String apiKey);
    }
}

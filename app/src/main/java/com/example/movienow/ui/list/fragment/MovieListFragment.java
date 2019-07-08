package com.example.movienow.ui.list.fragment;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.movienow.BuildConfig;
import com.example.movienow.R;
import com.example.movienow.base.BaseFragment;
import com.example.movienow.data.model.Movie;
import com.example.movienow.ui.list.adapter.MovieListAdapter;
import com.example.movienow.ui.list.contract.MovieListContract;
import com.example.movienow.ui.list.presenter.MovieListPresenter;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * doannd
 * <p>
 * movie list fragment
 */
public class MovieListFragment extends BaseFragment implements MovieListContract.View {


    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.rv_movie_list)
    RecyclerView rvMovieList;

    @Inject
    MovieListPresenter presenter;

    private MovieListAdapter adapter;
    private List<Movie> movieList = new ArrayList<>();

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
        rvMovieList.setHasFixedSize(true);
        rvMovieList.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        adapter = new MovieListAdapter(R.layout.item_movie_list, movieList);
        rvMovieList.setAdapter(adapter);

        presenter.getPopularMovies(BuildConfig.API_KEY);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie_list;
    }

    @Override
    public void showPopularMovies(List<Movie> list) {
        movieList.clear();
        movieList.addAll(list);
        adapter.notifyDataSetChanged();
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

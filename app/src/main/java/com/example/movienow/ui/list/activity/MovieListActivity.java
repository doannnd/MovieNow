package com.example.movienow.ui.list.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.widget.Toolbar;

import com.example.movienow.R;
import com.example.movienow.base.BaseActivity;
import com.google.android.material.appbar.AppBarLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author doannd
 * <p>
 * Movie List Activity
 */

public class MovieListActivity extends BaseActivity {

    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.container)
    FrameLayout container;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_movie_list;
    }

    @Override
    protected void attachView() {

    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void configViews() {

    }

    @Override
    protected void setupComponent() {
        getActivityComponent().inject(this);
    }

}

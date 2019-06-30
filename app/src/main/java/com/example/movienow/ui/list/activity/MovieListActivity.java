package com.example.movienow.ui.list.activity;

import com.example.movienow.R;
import com.example.movienow.base.BaseActivity;

/**
 * @author doannd
 *
 * Movie List Activity
 */

public class MovieListActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

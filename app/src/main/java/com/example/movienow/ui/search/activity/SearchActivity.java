package com.example.movienow.ui.search.activity;

import android.content.Context;
import android.content.Intent;

import com.example.movienow.base.BaseActivity;
import com.example.movienow.ui.list.activity.MovieListActivity;
import com.example.movienow.utils.Constants;

public class SearchActivity extends BaseActivity {


    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, SearchActivity.class));
    }


    @Override
    protected int getLayoutId() {
        return 0;
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

    }
}

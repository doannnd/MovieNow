package com.example.movienow.ui.list.activity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.movienow.R;
import com.example.movienow.base.BaseActivity;
import com.example.movienow.ui.list.fragment.MovieListFragment;
import com.google.android.material.appbar.AppBarLayout;

import butterknife.BindView;

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
    @BindView(R.id.common_toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_movie_list;
    }

    @Override
    protected void attachView() {
    }

    @Override
    protected void initDatas() {
        MovieListFragment movieListFragment = new MovieListFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, movieListFragment);
        transaction.commit();
    }

    @Override
    protected void configViews() {
        setSupportActionBar(toolbar);
    }

    @Override
    protected void setupComponent() {
        getActivityComponent().inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_search) {

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        appBarLayout.setExpanded(false, true);
    }
}

package com.example.movienow.ui.detail.activity;

import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movienow.R;
import com.example.movienow.base.BaseActivity;
import com.example.movienow.data.model.Movie;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * doannd
 * <p>
 * movie detail
 */
public class MovieDetailActivity extends BaseActivity {

    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.iv_backdrop)
    ImageView ivBackdrop;
    @BindView(R.id.layout_info)
    FrameLayout frameLayoutInfo;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_release_date)
    TextView tvReleasedate;
    @BindView(R.id.tv_rating)
    TextView tvRating;
    @BindView(R.id.iv_poster)
    ImageView ivPoster;
    @BindView(R.id.scroll_view)
    NestedScrollView scrollView;
    @BindView(R.id.tv_overview)
    TextView tvOverview;
    @BindView(R.id.ll_genre_container)
    LinearLayout llGenreContainer;
    @BindView(R.id.rv_genre)
    RecyclerView rvGenre;
    @BindView(R.id.ll_cast_container)
    LinearLayout llCastContainer;
    @BindView(R.id.bt_view_all_cast)
    Button btViewAllCast;
    @BindView(R.id.rv_cast)
    RecyclerView rvCast;

    private List<Movie> casts = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }


}

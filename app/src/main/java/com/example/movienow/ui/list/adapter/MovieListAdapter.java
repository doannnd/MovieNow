package com.example.movienow.ui.list.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.movienow.R;
import com.example.movienow.data.model.Movie;
import com.example.movienow.utils.UrlBuilder;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * doannd
 * <p>
 * Movie list adapter
 */
public class MovieListAdapter extends BaseQuickAdapter<Movie, BaseViewHolder> {

    public MovieListAdapter(int layoutResId, @Nullable List<Movie> movieList) {
        super(layoutResId, movieList);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, Movie movie) {
        Logger.d("title: %s", movie.getOriginalTitle());
        Logger.d("year: %s", movie.getReleaseDate());
        viewHolder.setText(R.id.tv_title, movie.getOriginalTitle())
                .setText(R.id.tv_year, movie.getReleaseDate());

        Logger.d("image url: %s", UrlBuilder.getPosterUrl(movie.getPosterPath()));
        // load poster image
        Glide.with(mContext).load(UrlBuilder.getPosterUrl(movie.getPosterPath()))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into((ImageView) viewHolder.getView(R.id.iv_poster));

    }
}

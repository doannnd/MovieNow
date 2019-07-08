package com.example.movienow.ui.list.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.palette.graphics.Palette;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
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
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        Bitmap bitmap = ((BitmapDrawable) resource.getCurrent()).getBitmap();
                        Palette palette = new Palette.Builder(bitmap).generate();
                        int defaultColor = 0xFF333333;
                        int color = palette.getDarkMutedColor(defaultColor);
                        viewHolder.itemView.setBackgroundColor(color);
                        return false;
                    }
                })
                .into((ImageView) viewHolder.getView(R.id.iv_poster));

    }
}

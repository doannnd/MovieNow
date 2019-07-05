package com.example.movienow.di.components;

import com.example.movienow.di.PerActivity;
import com.example.movienow.di.modules.ActivityModule;
import com.example.movienow.ui.detail.activity.MovieDetailActivity;
import com.example.movienow.ui.list.activity.MovieListActivity;
import com.squareup.leakcanary.internal.MoreDetailsView;

import dagger.Component;

/**
 * doannd
 *
 * inject Activity, Fragment here
 */

@PerActivity
@Component(dependencies = {
        ApplicationComponent.class,
        ActivityModule.class
})
public interface ActivityComponent {
    MovieListActivity inject(MovieListActivity movieListActivity);

    MovieDetailActivity inject(MovieDetailActivity movieDetailActivity);
}

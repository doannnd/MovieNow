package com.example.movienow.di.components;

import com.example.movienow.di.PerActivity;
import com.example.movienow.di.modules.ActivityModule;
import com.example.movienow.ui.detail.activity.MovieDetailActivity;
import com.example.movienow.ui.list.activity.MovieListActivity;
import com.example.movienow.ui.list.fragment.MovieListFragment;
import com.squareup.leakcanary.internal.MoreDetailsView;

import dagger.Component;

/**
 * doannd
 * <p>
 * inject Activity, Fragment here
 */

@PerActivity
@Component(dependencies = {
        ApplicationComponent.class
}, modules = {
        ActivityModule.class
})
public interface ActivityComponent {
    MovieListFragment inject(MovieListFragment movieListFragment);

    MovieDetailActivity inject(MovieDetailActivity movieDetailActivity);
}

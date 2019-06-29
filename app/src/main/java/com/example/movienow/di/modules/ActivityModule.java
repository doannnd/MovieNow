package com.example.movienow.di.modules;

import android.app.Activity;

import com.example.movienow.di.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * doannd
 *
 * activity module
 */

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Activity provideActivity() {
        return activity;
    }
}

package com.example.movienow;

import android.app.Application;
import android.content.Context;

import com.example.movienow.di.components.ApplicationComponent;
import com.example.movienow.di.components.DaggerApplicationComponent;
import com.example.movienow.di.modules.ApplicationModule;

/**
 * doannd
 *
 * config movie now application here
 */
public class MovieNowApplication extends Application {

    private ApplicationComponent applicationComponent;

    public static MovieNowApplication get(Context context) {
        return (MovieNowApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}

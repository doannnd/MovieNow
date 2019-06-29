package com.example.movienow;

import android.app.Application;
import android.content.Context;

import com.example.movienow.di.components.ApplicationComponent;
import com.example.movienow.di.components.DaggerApplicationComponent;
import com.example.movienow.di.modules.ApplicationModule;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

/**
 * doannd
 * <p>
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

        /**
         * DEBUG
         */
        if (BuildConfig.DEBUG) {
            setupLeakCanary();
            setupStetho();
        }


        setupComponent();
    }

    /**
     * setup Stetho: test api, database, shared references
     * version: 1.5.1
     * github:
     */
    private void setupStetho() {
        Stetho.initializeWithDefaults(this);
    }

    /**
     * setup leak canary
     * version: 1.6.2
     * github: https://github.com/square/leakcanary/tree/v1.6.2
     */
    private void setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    /**
     * setup application component (dagger2)
     * version: 2.7
     * github: https://github.com/google/dagger/tree/dagger-2.7
     */
    private void setupComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}

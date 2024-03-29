package com.example.movienow.di.components;

import android.app.Application;
import android.content.Context;

import com.example.movienow.MovieNowApplication;
import com.example.movienow.data.DataManager;
import com.example.movienow.di.ApplicationContext;
import com.example.movienow.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * doannd
 * <p>
 * inject Movie Now Application here
 * get data from services
 */

@Singleton
@Component(modules = {
        ApplicationModule.class
})
public interface ApplicationComponent {

    void inject(MovieNowApplication application);

    Application application();

    DataManager getDataManager();

}

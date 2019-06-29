package com.example.movienow.di.components;

import com.example.movienow.di.PerActivity;
import com.example.movienow.di.modules.ActivityModule;

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

}

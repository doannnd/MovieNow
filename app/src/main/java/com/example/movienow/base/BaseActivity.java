package com.example.movienow.base;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movienow.MovieNowApplication;
import com.example.movienow.di.components.ActivityComponent;
import com.example.movienow.di.components.DaggerActivityComponent;
import com.example.movienow.di.modules.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(MovieNowApplication.get(this).getComponent())
                    .build();
        }
        return  activityComponent;
    }
}

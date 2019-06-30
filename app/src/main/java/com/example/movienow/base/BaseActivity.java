package com.example.movienow.base;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movienow.MovieNowApplication;
import com.example.movienow.di.components.ActivityComponent;
import com.example.movienow.di.components.DaggerActivityComponent;
import com.example.movienow.di.modules.ActivityModule;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    protected String TAG = getClass().getName();
    protected Context context;

    private ActivityComponent activityComponent;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        unbinder = ButterKnife.bind(this);
        context = this;

        setupComponent();
        attachView();
        initDatas();
        configViews();
    }

    protected abstract int getLayoutId();

    protected abstract void attachView();

    protected abstract void initDatas();

    protected abstract void configViews();

    protected abstract void setupComponent();

    protected ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(MovieNowApplication.get(this).getComponent())
                    .build();
        }
        return  activityComponent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}

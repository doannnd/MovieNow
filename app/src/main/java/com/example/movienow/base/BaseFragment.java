package com.example.movienow.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.example.movienow.MovieNowApplication;
import com.example.movienow.di.components.ActivityComponent;
import com.example.movienow.di.components.DaggerActivityComponent;
import com.example.movienow.di.modules.ActivityModule;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends RxFragment {

    protected String TAG = getClass().getName();
    protected Context context;
    protected View parentView;
    protected FragmentActivity activity;
    protected LayoutInflater inflater;

    private Unbinder unbinder;
    private ActivityComponent activityComponent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(getLayoutId(), container, false);
        activity = getSupportActivity();
        context = activity;
        this.inflater = inflater;
        return parentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        setupComponent();
        attachView();
        initDatas();
        configViews();
    }

    protected abstract void setupComponent();

    protected abstract void attachView();

    protected abstract void initDatas();

    protected abstract void configViews();

    protected abstract int getLayoutId();

    protected FragmentActivity getSupportActivity() {
        return super.getActivity();
    }

    protected ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(activity))
                    .applicationComponent(MovieNowApplication.get(context).getComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (FragmentActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.activity = null;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}

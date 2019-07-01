package com.example.movienow.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import butterknife.Unbinder;

public abstract class BaseDialog extends DialogFragment implements DialogMvpView {

    private BaseActivity mActivity;
    private Unbinder mUnbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity mActivity = (BaseActivity) context;
            this.mActivity = mActivity;
            mActivity.onAttachFragment(this);
        }
    }

    @Override
    public void showLoading() {
        if (mActivity != null) {
            mActivity.showLoading();
        }
    }

    @Override
    public void hideLoading() {
        if (mActivity != null) {
            mActivity.hideLoading();
        }
    }


    @Override
    public void onError(int resId) {
        if (mActivity != null) {
            mActivity.onError(resId);
        }
    }

    @Override
    public void onError(String message) {
        if (mActivity != null) {
            mActivity.onError(message);
        }
    }

    @Override
    public void showMessage(String message) {
        if (mActivity != null) {
            mActivity.showMessage(message);
        }
    }

    @Override
    public void showMessage(int resId) {
        if (mActivity != null) {
            mActivity.showMessage(resId);
        }
    }

    @Override
    public void openActivityOnTokenExpire() {
        if (mActivity != null) {
            mActivity.openActivityOnTokenExpire();
        }
    }

    @Override
    public boolean isNetworkConnected() {
        if (mActivity != null) {
            return mActivity.isNetworkConnected();
        }
        return false;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnbinder = unBinder;
    }


    @Override
    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void show(FragmentManager fragmentManager, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment prevFragment = fragmentManager.findFragmentByTag(tag);
        if (prevFragment != null) {
            transaction.remove(prevFragment);
        }
        transaction.addToBackStack(null);
        show(transaction, tag);
    }

    @Override
    public void dismissDialog(String tag) {

    }

    @Override
    public void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

}

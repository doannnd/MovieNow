package com.example.movienow.base;

public interface BaseContract {
    interface BaseView {
        void showError();
    }

    interface BasePresenter<T> {
        void attachView(T view);

        void detachView();
    }
}

package com.example.movienow.base;

public interface BaseContract {
    interface BaseView {
        void showError();

        void complete();
    }

    interface BasePresenter<T> {
        void attachView(T view);

        void detachView();
    }
}

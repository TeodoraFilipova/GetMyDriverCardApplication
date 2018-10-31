package com.mystique.rt.getmydrivercardapplcation.views.statuscheck;

public interface StatusCheckContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showStatus(String status);

        void hideLoading();

        void showError(Throwable error);

        void showNotFound();

        void showLoading();
    }

    interface Presenter {
        void subscribe(View view);

        void checkStatus(String statusCheckCode);
    }
}

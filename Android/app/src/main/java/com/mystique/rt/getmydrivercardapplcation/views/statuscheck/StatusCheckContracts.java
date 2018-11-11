package com.mystique.rt.getmydrivercardapplcation.views.statuscheck;

/**
 * <h1>StatusCheckContracts</h1>
 *
 * <b>Description: </b> This interface defines the interfaces which are used by the
 * fragment, presenter, activity trio in order to implement the MVP pattern. It also handles
 * navigation.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
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

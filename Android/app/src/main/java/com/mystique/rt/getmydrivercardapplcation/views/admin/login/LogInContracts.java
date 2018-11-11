package com.mystique.rt.getmydrivercardapplcation.views.admin.login;

import com.mystique.rt.getmydrivercardapplcation.models.User;

import java.io.IOException;

/**
 * <h1>LogInContracts</h1>
 *
 * <b>Description: </b> This interface defines the interfaces which are used by the
 * fragment, presenter, activity trio in order to implement the MVP pattern. It also handles
 * navigation.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public interface LogInContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void logInUser(User user);

        void showWrongUserInfo();

        void showLoading();

        void hideLoading();

        void showError(Throwable error);
    }

    interface Presenter {
        void subscribe(View view);

        void loadUser(String userName, String password) throws IOException;
    }

    interface Navigator {
        void navigateToAdminPanel();
    }
}

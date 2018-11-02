package com.mystique.rt.getmydrivercardapplcation.views.admin.login;

import com.mystique.rt.getmydrivercardapplcation.models.User;

import java.io.IOException;

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

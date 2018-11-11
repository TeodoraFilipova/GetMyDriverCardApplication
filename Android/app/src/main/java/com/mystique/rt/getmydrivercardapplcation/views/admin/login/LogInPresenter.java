package com.mystique.rt.getmydrivercardapplcation.views.admin.login;

import com.mystique.rt.getmydrivercardapplcation.async.SchedulerProvider;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.models.User;
import com.mystique.rt.getmydrivercardapplcation.services.base.UserService;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

/**
 * <h1>LogInPresenter</h1>
 *
 * <b>Description: </b> This class is the Presenter of the MVP. It handles the logic
 * and tasks related to the visualization of the log in screen.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public class LogInPresenter implements LogInContracts.Presenter {
    private LogInContracts.View mView;
    private final UserService mUserService;
    private final SchedulerProvider mSchedulerProvider;

    @Inject
    public LogInPresenter(UserService mUserService, SchedulerProvider mSchedulerProvider) {
        this.mUserService = mUserService;
        this.mSchedulerProvider = mSchedulerProvider;
    }


    @Override
    public void subscribe(LogInContracts.View view) {
        mView = view;
    }

    @Override
    public void loadUser(String userName, String password) throws IOException {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<User>) emitter -> {
                    User user = mUserService.getUserByUsernameAndPassword(userName, password);
                    if (user == null) {
                        user = new User();
                    }
                    emitter.onNext(user);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(this::presentUserToView, error -> mView.showError(error));
    }

    private void presentUserToView(User user) {
        if (user.getUsername() != null && user.getPassword() != null) {
            mView.logInUser(user);
        } else {
            mView.showWrongUserInfo();
        }
    }
}

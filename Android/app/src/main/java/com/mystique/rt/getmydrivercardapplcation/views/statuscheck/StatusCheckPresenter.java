package com.mystique.rt.getmydrivercardapplcation.views.statuscheck;

import com.mystique.rt.getmydrivercardapplcation.async.SchedulerProvider;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.services.base.CardApplicationFormService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class StatusCheckPresenter implements StatusCheckContracts.Presenter {
    private final CardApplicationFormService mCardApplicationFormService;
    private final SchedulerProvider mSchedulerProvider;
    private StatusCheckContracts.View mView;

    @Inject
    public StatusCheckPresenter(CardApplicationFormService applicationFormService, SchedulerProvider schedulerProvider) {
        mCardApplicationFormService = applicationFormService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(StatusCheckContracts.View view) {
        mView = view;
    }

    @Override
    public void checkStatus(String statusCheckCode) {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<CardApplicationForm>) emitter -> {
                    CardApplicationForm applicationForm = mCardApplicationFormService.getFormByStatusCheckCode(statusCheckCode);
                    emitter.onNext(applicationForm);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(this::presentStatusToView, error -> mView.showError(error));
    }

    private void presentStatusToView(CardApplicationForm applicationForm) {
        if (applicationForm.getStatusCheckCode() == null) {
            mView.showNotFound();
        } else {
            mView.showStatus(applicationForm.getStatus());
        }
    }
}

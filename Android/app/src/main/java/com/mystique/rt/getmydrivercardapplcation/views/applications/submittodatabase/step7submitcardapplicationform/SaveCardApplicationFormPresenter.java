package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step7submitcardapplicationform;

import com.mystique.rt.getmydrivercardapplcation.async.SchedulerProvider;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.services.base.CardApplicationFormService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class SaveCardApplicationFormPresenter implements SaveCardApplicationFormContracts.Presenter {
    private final CardApplicationFormService mCardApplicationFormService;

    private final SchedulerProvider mSchedulerProvider;
    private SaveCardApplicationFormContracts.View mView;

    @Inject
    public SaveCardApplicationFormPresenter(CardApplicationFormService cardApplicationFormService, SchedulerProvider schedulerProvider) {
        mCardApplicationFormService = cardApplicationFormService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(SaveCardApplicationFormContracts.View view) {
        mView = view;
    }

    @Override
    public void saveCardApplicationForm(CardApplicationForm cardApplicationForm) {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<CardApplicationForm>) emitter -> {
                    CardApplicationForm form = mCardApplicationFormService.addForm(cardApplicationForm);
                    emitter.onNext(form);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::tellViewToSendEmailAndDisplayDoneMessage, error -> mView.showError(error));
    }

    private void tellViewToSendEmailAndDisplayDoneMessage(CardApplicationForm applicationForm) {
        mView.sendEmail();
    }

    @Override
    public void getLastUpdatedCardApplicationForm() {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<CardApplicationForm>) emitter -> {
                    CardApplicationForm applicationForm = mCardApplicationFormService.getLastUpdatedForm();
                    emitter.onNext(applicationForm);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::tellViewToSetNextApplicationId, error -> mView.showError(error));
    }

    private void tellViewToSetNextApplicationId(CardApplicationForm lastUpdatedCardApplicationForm) {
        mView.setNextCardApplicationFormId(lastUpdatedCardApplicationForm);
    }

    @Override
    public void updateLastCardApplicationForm(CardApplicationForm cardApplicationForm) {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<CardApplicationForm>) emitter -> {
                    cardApplicationForm.setLastUpdated("");
                    CardApplicationForm applicationForm = mCardApplicationFormService.updateFormById
                            (cardApplicationForm.getCardApplicationFormId(), cardApplicationForm);
                    emitter.onNext(applicationForm);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::tellViewToUpdateRememberAll, error -> mView.showError(error));
    }

    private void tellViewToUpdateRememberAll(CardApplicationForm lastUpdatedCardApplicationForm) {
        mView.updateRememberAll();
    }
}

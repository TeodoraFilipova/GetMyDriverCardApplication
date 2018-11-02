package com.mystique.rt.getmydrivercardapplcation.views.admin.applicationslist;


import com.mystique.rt.getmydrivercardapplcation.async.SchedulerProvider;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.services.HttpCardApplicationFormService;
import com.mystique.rt.getmydrivercardapplcation.views.admin.details.CardApplicationDetailsContracts;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class CardApplicatioFormsListPresenter implements CardApplicationFormsListContracts.Presenter {
    private final HttpCardApplicationFormService mCardAppFormService;
    private final SchedulerProvider mSchedulerProvider;
    private CardApplicationFormsListContracts.View mView;

    @Inject
    public CardApplicatioFormsListPresenter(HttpCardApplicationFormService formsService, SchedulerProvider schedulerProvider) {
        mCardAppFormService = formsService;
        mSchedulerProvider = schedulerProvider;
    }


    @Override
    public void subscribe(CardApplicationFormsListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadCardApplicationsForms() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<CardApplicationForm>>) emitter -> {
                    List<CardApplicationForm> forms = mCardAppFormService.getAllForms();
                    emitter.onNext(forms);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(this::presentFormsToView, error -> mView.showError(error));
    }

   @Override
    public void filterCardApplicationFormsByID(String pattern) {
       mView.showLoading();
       Disposable observable = Observable
               .create((ObservableOnSubscribe<List<CardApplicationForm>>) emitter -> {
                   List<CardApplicationForm> forms = mCardAppFormService.getFilteredFormsByID(pattern);
                   emitter.onNext(forms);
                   emitter.onComplete();
               })
               .subscribeOn(mSchedulerProvider.background())
               .observeOn(mSchedulerProvider.ui())
               .doFinally(mView::hideLoading)
               .subscribe(this::presentFormsToView, error -> mView.showError(error));
    }

    @Override
    public void filterCardApplicationFormsByName(String pattern) {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<CardApplicationForm>>) emitter -> {
                    List<CardApplicationForm> forms = mCardAppFormService.getFilteredFormsByName(pattern);
                    emitter.onNext(forms);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(this::presentFormsToView, error -> mView.showError(error));

    }

    @Override
    public void filterCardApplicationFormsBySubmissionDate(String pattern) {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<CardApplicationForm>>) emitter -> {
                    List<CardApplicationForm> forms = mCardAppFormService.getFilteredProductsBySubbmisitonDate(pattern);
                    emitter.onNext(forms);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(this::presentFormsToView, error -> mView.showError(error));
    }


    @Override
    public void filterCardApplicationFormsByStatus(String status) {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<CardApplicationForm>>) emitter -> {
                    List<CardApplicationForm> forms = mCardAppFormService.getFilteredProductsByStatus(status);
                    emitter.onNext(forms);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(this::presentFormsToView, error -> mView.showError(error));
    }


    @Override
    public void selectCardApplicationForm(CardApplicationForm cardApplicationForm) {
        mView.showCardApplicationsDetails(cardApplicationForm);
    }



    private void presentFormsToView(List<CardApplicationForm> forms) {
        if (forms.isEmpty()) {
            mView.showEmptyCardApplicationsList();
        } else {
            mView.showCardApplications(forms);
        }
    }
}

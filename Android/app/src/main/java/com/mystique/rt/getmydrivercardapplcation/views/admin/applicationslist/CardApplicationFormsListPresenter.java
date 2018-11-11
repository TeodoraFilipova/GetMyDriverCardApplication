


package com.mystique.rt.getmydrivercardapplcation.views.admin.applicationslist;

import com.mystique.rt.getmydrivercardapplcation.async.SchedulerProvider;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.services.base.CardApplicationFormService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

/**
 * <h1>CardApplicationFormListPresenter</h1>
 *
 * <b>Description: </b> This class is the Presenter of the MVP. It handles the logic
 * and tasks related to the visualization of application forms in the form of a list.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public class CardApplicationFormsListPresenter implements CardApplicationFormsListContracts.Presenter {
    private final CardApplicationFormService mCardAppFormService;
    private final SchedulerProvider mSchedulerProvider;
    private CardApplicationFormsListContracts.View mView;

    @Inject
    public CardApplicationFormsListPresenter(CardApplicationFormService formsService, SchedulerProvider schedulerProvider) {
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
    public void filterCardApplicationFormsByPersonalNumber(String pattern) {
       mView.showLoading();
       Disposable observable = Observable
               .create((ObservableOnSubscribe<List<CardApplicationForm>>) emitter -> {
                   List<CardApplicationForm> forms = mCardAppFormService.getFilteredFormsByPersonalNumber(pattern);
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
                    List<CardApplicationForm> forms = mCardAppFormService.getFilteredFormsBySubmissionDate(pattern);
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
                    List<CardApplicationForm> forms = mCardAppFormService.getFilteredFormsByStatus(status);
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

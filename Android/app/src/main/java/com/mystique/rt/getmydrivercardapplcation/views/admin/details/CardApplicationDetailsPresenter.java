package com.mystique.rt.getmydrivercardapplcation.views.admin.details;

import com.mystique.rt.getmydrivercardapplcation.apputils.email.SendMail;
import com.mystique.rt.getmydrivercardapplcation.async.SchedulerProvider;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.services.base.CardApplicationFormService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class CardApplicationDetailsPresenter implements CardApplicationDetailsContracts.Presenter {
    private final CardApplicationFormService mFormService;
    private final SchedulerProvider mSchedulerProvider;

    private CardApplicationDetailsContracts.View mView;
    private int mCardApplicationFormId;

    @Inject
    public CardApplicationDetailsPresenter(
            CardApplicationFormService formService,
            SchedulerProvider schedulerProvider
    ) {
        mFormService = formService;
        mSchedulerProvider = schedulerProvider;
    }



    @Override
    public void subscribe(CardApplicationDetailsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadCardApplicationForm() {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<CardApplicationForm>) emitter ->
                        {CardApplicationForm form = mFormService.getFormById(mCardApplicationFormId);
                        emitter.onNext(form);
                        emitter.onComplete();
                        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(mView::showError)
                .subscribe(mView::showCardApplicationFormDetails);
    }

    @Override
    public void updateCardApplicationForm(String item) {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<CardApplicationForm>) emitter -> {
                    CardApplicationForm form = mFormService.getFormById(mCardApplicationFormId);
                    form.setStatus(item);
                    mFormService.updateFormById(mCardApplicationFormId, form);
                    emitter.onNext(form);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(mView::showError)
                .subscribe(mView::showCardApplicationFormDetails);
    }

    @Override
    public void sendMail(String item) {

       /* //Getting content for email
        String email = editTextEmail.getText().toString().trim();
        String subject = editTextSubject.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();*/

    }

    @Override
    public void setCardApplicationFormId(int id) { mCardApplicationFormId = id;

    }
}

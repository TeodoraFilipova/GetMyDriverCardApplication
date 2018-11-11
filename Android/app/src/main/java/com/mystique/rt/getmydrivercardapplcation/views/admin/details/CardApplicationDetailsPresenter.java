package com.mystique.rt.getmydrivercardapplcation.views.admin.details;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.mystique.rt.getmydrivercardapplcation.apputils.Constants;
import com.mystique.rt.getmydrivercardapplcation.apputils.RememberAll;
import com.mystique.rt.getmydrivercardapplcation.apputils.email.SendMail;
import com.mystique.rt.getmydrivercardapplcation.async.SchedulerProvider;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.services.base.CardApplicationFormService;
import com.mystique.rt.getmydrivercardapplcation.services.base.DriverService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

/**
 * <h1>CardApplicationDetailsPresenter</h1>
 *
 * <b>Description: </b> This class is the Presenter of the MVP. It handles the logic
 * and tasks related to the visualization of an application's fields.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public class CardApplicationDetailsPresenter implements CardApplicationDetailsContracts.Presenter {
    private final CardApplicationFormService mFormService;
    private final DriverService mDriverService;
    private final SchedulerProvider mSchedulerProvider;

    private CardApplicationDetailsContracts.View mView;
    private int mCardApplicationFormId;


    @Inject
    public CardApplicationDetailsPresenter(
            CardApplicationFormService formService,
            DriverService driverService,
            SchedulerProvider schedulerProvider
    ) {
        mFormService = formService;
        mDriverService = driverService;
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
    public void setCardApplicationFormId(int id) { mCardApplicationFormId = id;

    }

    @Override
    public void updateDriver(Driver updatedDriver) {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Driver>) emitter -> {
                    Driver dr = mDriverService.updateDriverById(updatedDriver.getDriverId(), updatedDriver);
                    emitter.onNext(dr);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(mView::hideLoading, error -> mView.showError(error));
    }

    @Override
    public void sendMail(Context context, String mail, String status, String office) {
        String email = mail;
        String subject = Constants.STATUS_EMAIL_SUBJECT;
        String message;
        if (status.equals("completed")){
            message = Constants.STATUS_EMAIL_MESSAGE1  + status + ". "
                    + Constants.STATUS_EMAIL_MESSAGE2 + office;
        } else {
            message = Constants.STATUS_EMAIL_MESSAGE1  + status + ". ";
        }
        SendMail sm = new SendMail(context, email, subject, message);
        sm.execute();

        mView.showMessageApplicationStatusChange();

    }
}

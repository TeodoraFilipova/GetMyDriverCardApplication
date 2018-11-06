package com.mystique.rt.getmydrivercardapplcation.views.applications;

import com.mystique.rt.getmydrivercardapplcation.apputils.Constants;
import com.mystique.rt.getmydrivercardapplcation.apputils.RememberAll;
import com.mystique.rt.getmydrivercardapplcation.apputils.email.SendMail;
import com.mystique.rt.getmydrivercardapplcation.async.SchedulerProvider;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.models.Picture;
import com.mystique.rt.getmydrivercardapplcation.services.base.CardApplicationFormService;
import com.mystique.rt.getmydrivercardapplcation.services.base.DriverService;
import com.mystique.rt.getmydrivercardapplcation.services.base.PictureService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class CompletedApplicationPresenter implements CompletedApplicationContracts.Presenter{
    private final CardApplicationFormService mCardApplicationFormService;
    private final DriverService mDriverService;
    private final PictureService mPictureService;

    private final SchedulerProvider mSchedulerProvider;
    private CompletedApplicationContracts.View mView;
    private RememberAll mRememberAll;

    @Inject
    public CompletedApplicationPresenter(CardApplicationFormService applicationFormService, DriverService driverService,
                                         PictureService pictureService, SchedulerProvider schedulerProvider) {
        mCardApplicationFormService = applicationFormService;
        mDriverService = driverService;
        mPictureService = pictureService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(CompletedApplicationContracts.View view, RememberAll rememberAll) {
        mView = view;
        mRememberAll = rememberAll;
    }

//    private void getLastUpdatedPicture() {
//        Disposable observable = Observable
//                .create((ObservableOnSubscribe<Picture>) emitter -> {
//                    Picture pic = mPictureService.getLastUpdatedPicture();
//                    emitter.onNext(pic);
//                    emitter.onComplete();
//                })
//                .subscribeOn(mSchedulerProvider.background())
//                .observeOn(mSchedulerProvider.ui())
//                .subscribe(this::getNextPictureId, error -> mView.showError(error));
//    }

    private int getNextPictureId(Picture picture) {
        return picture.getPictureId() + 1;
    }

    @Override
    public void savePicture(Picture picture) {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Picture>) emitter -> {
                    Picture pic = mPictureService.addPicture(picture);
                    emitter.onNext(pic);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::tellViewPicSaveSuccessful, error -> mView.showError(error));
    }

    @Override
    public void saveDriver(Driver driver) {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Driver>) emitter -> {
                    Driver dr = mDriverService.addDriver(driver);
                    emitter.onNext(dr);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::tellViewDriverSaveSuccessful, error -> mView.showError(error));
    }

    @Override
    public void saveCardApplicationForm(CardApplicationForm cardApplicationForm) {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<CardApplicationForm>) emitter -> {
                    CardApplicationForm applicationForm = mCardApplicationFormService.addForm(cardApplicationForm);
                    emitter.onNext(applicationForm);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::tellViewCardApplicationFormSaveSuccessful, error -> mView.showError(error));
    }

    @Override
    public void getLastUpdatedPicture() {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Picture>) emitter -> {
                    Picture pic = mPictureService.getLastUpdatedPicture();
                    emitter.onNext(pic);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::updateLastPicture, error -> mView.showError(error));
    }

    @Override
    public void getLastUpdatedDriver() {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Driver>) emitter -> {
                    Driver dr = mDriverService.getLastUpdatedDriver();
                    emitter.onNext(dr);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::updateLastDriver, error -> mView.showError(error));
    }

    @Override
    public void getLastUpdatedCardApplicationForm() {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<CardApplicationForm>) emitter -> {
                    CardApplicationForm form = mCardApplicationFormService.getLastUpdatedForm();
                    emitter.onNext(form);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::updateLastCardApplicationForm, error -> mView.showError(error));
    }

    @Override
    public void findDriver(String personalNumber) {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Driver>) emitter -> {
                    Driver dr = mDriverService.getDriverByPersonalNumber(personalNumber);
                    emitter.onNext(dr);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::updateCurrentDriver, error -> mView.showError(error));
    }

    private void updateCurrentDriver(Driver driverToUpdate) {
        mRememberAll.getCardApplicationForm().getDriver().setDriverId(driverToUpdate.getDriverId());
        Driver updatedDriver = mRememberAll.getCardApplicationForm().getDriver();

        Disposable observable = Observable
                .create((ObservableOnSubscribe<Driver>) emitter -> {
                    Driver dr = mDriverService.updateDriverById(driverToUpdate.getDriverId(), updatedDriver);
                    emitter.onNext(dr);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::tellViewDriverSaveSuccessful, error -> mView.showError(error));
    }

    private void updateLastCardApplicationForm(CardApplicationForm cardApplicationForm) {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<CardApplicationForm>) emitter -> {
                    cardApplicationForm.setLastUpdated("");
                    CardApplicationForm applicationForm = mCardApplicationFormService
                            .updateFormById(cardApplicationForm.getCardApplicationFormId(), cardApplicationForm);
                    emitter.onNext(applicationForm);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::getNextAvailableCardApplicationFormId, error -> mView.showError(error));
    }

    private void updateLastDriver(Driver driver) {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Driver>) emitter -> {
                    driver.setLastUpdated("");
                    Driver dr = mDriverService.updateDriverById(driver.getDriverId(), driver);
                    emitter.onNext(dr);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::getNextAvailableDriverId, error -> mView.showError(error));
    }

    private void updateLastPicture(Picture picture) {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Picture>) emitter -> {
                    picture.setLastUpdated("");
                    Picture pic = mPictureService.updatePictureById(picture.getPictureId(), picture);
                    emitter.onNext(pic);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::getNextAvailablePicId, error -> mView.showError(error));
    }

    private void getNextAvailablePicId(Picture picture) {
        int nextPictId = picture.getPictureId() + 1;
        mView.setNextPictureId(nextPictId);
    }

    private void getNextAvailableDriverId(Driver driver) {
        int nextDriverId = driver.getDriverId() + 1;
        mView.setNextDriverId(nextDriverId);
    }

    private void getNextAvailableCardApplicationFormId(CardApplicationForm cardApplicationForm) {
        int nextCardApplicationFormId = cardApplicationForm.getCardApplicationFormId() + 1;
        mView.setNextCardApplicationFormId(nextCardApplicationFormId);
    }

    private void tellViewPicSaveSuccessful(Picture picture) {
        mView.showFirstMessage();
    }

    private void tellViewDriverSaveSuccessful(Driver driver) {
        mView.showSecondMessage();
    }

    private void tellViewCardApplicationFormSaveSuccessful(CardApplicationForm cardApplicationForm) {
        mView.showMessageApplicationCompleted();
    }
}

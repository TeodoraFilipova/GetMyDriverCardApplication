package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step1submitselfie;

import com.mystique.rt.getmydrivercardapplcation.apputils.RememberAll;
import com.mystique.rt.getmydrivercardapplcation.async.SchedulerProvider;
import com.mystique.rt.getmydrivercardapplcation.models.Picture;
import com.mystique.rt.getmydrivercardapplcation.services.base.PictureService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class SaveSelfiePresenter implements SaveSelfieContracts.Presenter {
    private final PictureService mPictureService;

    private final SchedulerProvider mSchedulerProvider;
    private SaveSelfieContracts.View mView;

    @Inject
    public SaveSelfiePresenter(PictureService pictureService, SchedulerProvider schedulerProvider) {
        mPictureService = pictureService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(SaveSelfieContracts.View view) {
        mView = view;
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
                .subscribe(this::tellViewToNavigateToNextSaveActivity, error -> mView.showError(error));
    }

    private void tellViewToNavigateToNextSaveActivity(Picture picture) {
        mView.moveOnToNextSaveActivity();
    }

    @Override
    public void getLastUpdatedPicture() {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Picture>) emitter -> {
                    Picture lastUpdatedPicture = mPictureService.getLastUpdatedPicture();
                    emitter.onNext(lastUpdatedPicture);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::tellViewToSetNextPicId, error -> mView.showError(error));
//        Picture picture = new Picture();
//        picture.setPictureId(68);
//        tellViewToSetNextPicId(picture);
    }

    private void tellViewToSetNextPicId(Picture lastUpdatedPic) {
        mView.setNextPictureId(lastUpdatedPic);
    }

    @Override
    public void updateLastPicture(Picture picture) {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Picture>) emitter -> {
                    picture.setLastSetID("");
                    Picture pic = mPictureService.updatePictureById(picture.getPictureId(), picture);
                    emitter.onNext(pic);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::tellViewToUpdateRememberAll, error -> mView.showError(error));
      //  tellViewToUpdateRememberAll(picture);
    }

    private void tellViewToUpdateRememberAll(Picture lastUpdatedPicture) {
        mView.updateRememberAll();
    }
}

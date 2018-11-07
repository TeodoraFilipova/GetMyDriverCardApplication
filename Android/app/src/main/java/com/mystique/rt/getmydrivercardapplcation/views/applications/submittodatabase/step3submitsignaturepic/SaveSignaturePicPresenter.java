package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step3submitsignaturepic;

import com.mystique.rt.getmydrivercardapplcation.async.SchedulerProvider;
import com.mystique.rt.getmydrivercardapplcation.models.Picture;
import com.mystique.rt.getmydrivercardapplcation.services.base.PictureService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class SaveSignaturePicPresenter implements SaveSignaturePicContracts.Presenter {
    private final PictureService mPictureService;

    private final SchedulerProvider mSchedulerProvider;
    private SaveSignaturePicContracts.View mView;

    @Inject
    public SaveSignaturePicPresenter(PictureService pictureService, SchedulerProvider schedulerProvider) {
        mPictureService = pictureService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(SaveSignaturePicContracts.View view) {
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
    }

    private void tellViewToSetNextPicId(Picture lastUpdatedPic) {
        mView.setNextPictureId(lastUpdatedPic);
    }

    @Override
    public void updateLastPicture(Picture picture) {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Picture>) emitter -> {
                    picture.setLastUpdated("");
                    Picture pic = mPictureService.updatePictureById(picture.getPictureId(), picture);
                    emitter.onNext(pic);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::tellViewToUpdateRememberAll, error -> mView.showError(error));
    }

    private void tellViewToUpdateRememberAll(Picture lastUpdatedPicture) {
        mView.updateRememberAll();
    }
}

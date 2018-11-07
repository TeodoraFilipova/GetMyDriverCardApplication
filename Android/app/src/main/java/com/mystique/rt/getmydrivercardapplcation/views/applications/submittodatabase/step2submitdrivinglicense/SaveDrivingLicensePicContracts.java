package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step2submitdrivinglicense;

import com.mystique.rt.getmydrivercardapplcation.models.Picture;

public interface SaveDrivingLicensePicContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showError(Throwable error);

        void showLoading();

        void setNextPictureId(Picture lastUpdatedPicture);

        void updateRememberAll();

        void moveOnToNextSaveActivity();
    }

    interface Presenter {
        void subscribe(View view);

        void savePicture(Picture picture);

        void getLastUpdatedPicture();

        void updateLastPicture(Picture picture);
    }

    interface Navigator {
        void navigateToNextActivity();
    }
}

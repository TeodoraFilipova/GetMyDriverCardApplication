package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step1submitselfie;

import com.mystique.rt.getmydrivercardapplcation.apputils.RememberAll;
import com.mystique.rt.getmydrivercardapplcation.models.Picture;

public interface SaveSelfieContracts {
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

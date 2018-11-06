package com.mystique.rt.getmydrivercardapplcation.views.applications;

import com.mystique.rt.getmydrivercardapplcation.apputils.RememberAll;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.models.Picture;

public interface CompletedApplicationContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showMessageApplicationCompleted();

        void hideLoading();

        void showError(Throwable error);

        void showLoading();

        void setNextPictureId(int nextPictureId);

        void setNextDriverId(int nextDriverId);

        void setNextCardApplicationFormId(int nextCardApplicationFormId);

        void showFirstMessage();

        void showSecondMessage();

        void sendMail();
    }

    interface Presenter {
        void subscribe(View view, RememberAll rememberAll);

     //   void saveAllObjects();

        void savePicture(Picture picture);

        void saveDriver(Driver driver);

        void saveCardApplicationForm(CardApplicationForm cardApplicationForm);

        void getLastUpdatedPicture();

        void getLastUpdatedDriver();

        void getLastUpdatedCardApplicationForm();

        void findDriver(String personalNumber);
    }
}

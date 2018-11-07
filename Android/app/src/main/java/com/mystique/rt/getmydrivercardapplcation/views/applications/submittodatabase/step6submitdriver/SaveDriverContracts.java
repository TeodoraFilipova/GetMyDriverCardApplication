package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step6submitdriver;

import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.models.Picture;

import java.util.List;

public interface SaveDriverContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showError(Throwable error);

        void showLoading();

        void setNextDriverId(Driver lastUpdatedDriver);

        void updateRememberAll();

        void moveOnToNextSaveActivity();

        void checkIfDriverExists(List<Driver> drivers);
    }

    interface Presenter {
        void subscribe(View view);

        void saveDriver(Driver driver);

        void getLastUpdatedDriver();

        void updateLastDriver(Driver driver);

        void getAllDrivers();

        void updateExistingDriver(Driver driver);
    }

    interface Navigator {
        void navigateToNextActivity();
    }
}

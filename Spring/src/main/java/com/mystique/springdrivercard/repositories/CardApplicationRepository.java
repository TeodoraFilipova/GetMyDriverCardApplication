package com.mystique.springdrivercard.repositories;

import com.mystique.springdrivercard.models.CardApplicationForm;
import com.mystique.springdrivercard.models.DriverDetailsForm;
import com.mystique.springdrivercard.models.Picture;

import java.util.List;

public interface CardApplicationRepository {

    List<CardApplicationForm> getAllCardApplications();

    CardApplicationForm getCardApplicationsByID(int id);

    void updateCardApplication(int id, CardApplicationForm cardApplicationForm);

    // if we need driver from CardAppForm
    DriverDetailsForm getDriverByID(int id);

    void updateDriverDetailsForm(int id, DriverDetailsForm driver);

    void addNewDriverDetails(DriverDetailsForm driver);

    // if we need picture from CardAppForm
    Picture getPictureByID(int id);

    void addNewPicture(Picture picture);

}

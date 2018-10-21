package com.mystique.springtruckercard.repositories;

import com.mystique.springtruckercard.models.CardApplicationForm;
import com.mystique.springtruckercard.models.DriverDetailsForm;
import com.mystique.springtruckercard.models.Picture;

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

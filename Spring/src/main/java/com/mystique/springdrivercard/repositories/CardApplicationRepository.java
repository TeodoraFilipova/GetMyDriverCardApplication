package com.mystique.springdrivercard.repositories;

import com.mystique.springdrivercard.models.CardApplicationForm;
import com.mystique.springdrivercard.models.Driver;
import com.mystique.springdrivercard.models.Picture;

import java.util.List;

public interface CardApplicationRepository {

    // CardApplicationForm
    List<CardApplicationForm> getAllCardApplications();

    CardApplicationForm getCardApplicationByID(int id);

    void updateCardApplication(int id, CardApplicationForm cardApplicationForm);

    // Driver: if we need driver from CardAppForm
    Driver getDriverByID(int id);

    void updateDriverDetailsForm(int id, Driver driver);

    void addNewDriverDetailsForm(Driver driver);

    // Picture: if we need picture from CardAppForm
    Picture getPictureByID(int id);

    void addNewPicture(Picture picture);

}

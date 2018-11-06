package com.mystique.springdrivercard.repositories;

import com.mystique.springdrivercard.models.CardApplicationForm;
import com.mystique.springdrivercard.models.Driver;
import com.mystique.springdrivercard.models.Picture;
import com.mystique.springdrivercard.models.User;

import java.util.List;

public interface CardApplicationRepository {

    // CardApplicationForm
    void addCardApplicationForm(CardApplicationForm cardApplicationForm);
    // when adding new appform, could check if driver excists or add first the driver

    List<CardApplicationForm> getAllCardApplications();

    CardApplicationForm getCardApplicationByID(int id);

    void updateCardApplication(int id, CardApplicationForm cardApplicationForm);

    // Driver: if we need driver from CardAppForm
    void addDriver(Driver driver);

    Driver getDriverByID(int id);

    List<Driver> getAllDrivers();

    void updateDriver(int id, Driver driver);


    // Picture: if we need picture from CardAppForm
    Picture getPictureByID(int id);

    List<Picture> getAllPictures();

    void addNewPicture(Picture picture);

    void updatePicture(int id, Picture picture);


    // User to check in login
    List<User> getAllUsers();

}

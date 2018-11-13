package com.mystique.springdrivercard.repositories;

import com.mystique.springdrivercard.models.CardApplicationForm;
import com.mystique.springdrivercard.models.Driver;
import com.mystique.springdrivercard.models.Picture;
import com.mystique.springdrivercard.models.User;

import java.util.List;

/**
 * <h1>CardApplicationFormRepository interface</h1>
 *
 * <b>Description: </b> This interface defines the methods for the
 * repository layer (get, add, update) of CardApplicationForm,
 * Driver, Picture and User models.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public interface CardApplicationRepository {

    // CardApplicationForm
    CardApplicationForm addCardApplicationForm(CardApplicationForm cardApplicationForm);

    List<CardApplicationForm> getAllCardApplications();

    CardApplicationForm getCardApplicationByID(int id);

    CardApplicationForm updateCardApplication(int id, CardApplicationForm cardApplicationForm);

    // Driver
    Driver addDriver(Driver driver);

    Driver getDriverByID(int id);

    List<Driver> getAllDrivers();

    Driver updateDriver(int id, Driver driver);


    // Picture
    Picture getPictureByID(int id);

    List<Picture> getAllPictures();

    Picture addNewPicture(Picture picture);

    Picture updatePicture(int id, Picture picture);


    // User to check in login
    List<User> getAllUsers();

}

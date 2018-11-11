/**
 * <h1>ServicesModule</h1>
 *
 * <b>Description: </b> This class is a part of the Dagger dependency injection configuration.
 * It provides and injects instances of CardApplicationFormService, DriverService, PictureService,
 * and UserService.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.CardApplicationFormRepository;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.DriverRepository;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.PictureRepository;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.UserRepository;
import com.mystique.rt.getmydrivercardapplcation.services.HttpCardApplicationFormService;
import com.mystique.rt.getmydrivercardapplcation.services.HttpDriverService;
import com.mystique.rt.getmydrivercardapplcation.services.HttpPictureService;
import com.mystique.rt.getmydrivercardapplcation.services.HttpUserService;
import com.mystique.rt.getmydrivercardapplcation.services.base.CardApplicationFormService;
import com.mystique.rt.getmydrivercardapplcation.services.base.DriverService;
import com.mystique.rt.getmydrivercardapplcation.services.base.PictureService;
import com.mystique.rt.getmydrivercardapplcation.services.base.UserService;
import com.mystique.rt.getmydrivercardapplcation.validators.base.Validator;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    public CardApplicationFormService cardApplicationFormService(CardApplicationFormRepository repository, Validator<CardApplicationForm> validator) {
        return new HttpCardApplicationFormService(repository, validator);
    }

    @Provides
    public DriverService driverService(DriverRepository repository, Validator<Driver> validator) {
        return new HttpDriverService(repository, validator);
    }

    @Provides
    public PictureService pictureService(PictureRepository repository) {
        return new HttpPictureService(repository);
    }

    @Provides
    public UserService userService(UserRepository repository) {
        return new HttpUserService(repository);
    }
}

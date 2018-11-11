

package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.validators.CardApplicationFormValidator;
import com.mystique.rt.getmydrivercardapplcation.validators.DriverValidator;
import com.mystique.rt.getmydrivercardapplcation.validators.base.Validator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * <h1>ValidatorsModule</h1>
 *
 * <b>Description: </b> This class is a part of the Dagger dependency injection configuration.
 * It provides and injects instances of DriverValidator and CardApplicationFormValidator.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
@Module
public class ValidatorsModule {
    @Provides
    @Singleton
    public Validator<Driver> driverValidator() {
        return new DriverValidator();
    }

    @Provides
    @Singleton
    public Validator<CardApplicationForm> applicationValidator() {
        return new CardApplicationFormValidator();
    }
}

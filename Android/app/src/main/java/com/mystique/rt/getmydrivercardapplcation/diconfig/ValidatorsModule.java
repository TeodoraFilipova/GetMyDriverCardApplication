package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.validators.DriverValidator;
import com.mystique.rt.getmydrivercardapplcation.validators.base.Validator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ValidatorsModule {
    @Provides
    // @Singleton
    public Validator<Driver> driverValidator() {
        return new DriverValidator();
    }
}

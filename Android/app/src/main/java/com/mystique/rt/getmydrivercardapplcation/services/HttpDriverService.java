package com.mystique.rt.getmydrivercardapplcation.services;

import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.DriverRepository;
import com.mystique.rt.getmydrivercardapplcation.services.base.DriverService;
import com.mystique.rt.getmydrivercardapplcation.validators.base.Validator;

import java.io.IOException;

public class HttpDriverService implements DriverService {
    private final DriverRepository mDriverRepository;
    private final Validator<Driver> mDriverValidator;

    public HttpDriverService(DriverRepository driverRepository, Validator<Driver> driverValidator) {
        mDriverRepository = driverRepository;
        mDriverValidator = driverValidator;
    }


    @Override
    public Driver addDriver(Driver driver) throws IOException {
        if (!mDriverValidator.isValid(driver)) {
            throw new IllegalArgumentException("Driver information is invalid!");
        }
        return mDriverRepository.add(driver);
    }

    @Override
    public Driver getDriverById(int id) throws IOException {
        return mDriverRepository.getById(id);
    }

    @Override
    public Driver updateDriverById(int id, Driver driver) throws IOException {
        if (!mDriverValidator.isValid(driver)) {
            throw new IllegalArgumentException("Driver information is invalid!");
        }
        return mDriverRepository.updateById(id, driver);
    }
}

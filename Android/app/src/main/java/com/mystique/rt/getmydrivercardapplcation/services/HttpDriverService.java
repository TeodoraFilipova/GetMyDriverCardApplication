package com.mystique.rt.getmydrivercardapplcation.services;

import com.mystique.rt.getmydrivercardapplcation.apputils.Constants;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.DriverRepository;
import com.mystique.rt.getmydrivercardapplcation.services.base.DriverService;
import com.mystique.rt.getmydrivercardapplcation.validators.base.Validator;

import java.io.IOException;
import java.util.List;

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
    public Driver getDriverByPersonalNumber(String personalNumber) throws IOException {
        List<Driver> allDrivers = getAllDrivers();
        for (Driver driver : allDrivers) {
            if (driver.getPersonalNumber().equals(personalNumber)) {
                return driver;
            }
        }
        return null;
    }

    @Override
    public List<Driver> getAllDrivers() throws IOException {
        return mDriverRepository.getAllDrivers();
    }

    @Override
    public Driver updateDriverById(int id, Driver driver) throws IOException {
        if (!mDriverValidator.isValid(driver)) {
            throw new IllegalArgumentException("Driver information is invalid!");
        }
        return mDriverRepository.updateById(id, driver);
    }

    @Override
    public Driver getLastUpdatedDriver() throws IOException {
        List<Driver> allDrivers = getAllDrivers();
        for (Driver driver : allDrivers) {
            if (driver.getLastUpdated().equals(Constants.LAST_UPDATED_TRUE)) {
                return driver;
            }
        }
        return null;
    }
}

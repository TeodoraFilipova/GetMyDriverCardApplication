package com.mystique.springdrivercard.services.driverService;

import com.mystique.springdrivercard.models.Driver;

import java.util.List;

public interface DriverService {

    void addDriver(Driver driver);
    Driver getDriverByID(int id);
    List<Driver> getAllDrivers();
    void updateDriver(int id, Driver driver);

}

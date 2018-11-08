package com.mystique.springdrivercard.services.driverService;

import com.mystique.springdrivercard.models.Driver;

import java.util.List;

public interface DriverService {

    Driver addDriver(Driver driver);
    Driver getDriverByID(int id);
    List<Driver> getAllDrivers();
    Driver updateDriver(int id, Driver driver);

}

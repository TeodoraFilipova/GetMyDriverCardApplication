package com.mystique.springdrivercard.services.driverService;

import com.mystique.springdrivercard.models.Driver;

public interface DriverService {

    void addDriver(Driver driver);
    Driver getDriverByID(int id);
    void updateDriver(int id, Driver driver);

}

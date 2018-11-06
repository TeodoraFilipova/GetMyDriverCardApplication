package com.mystique.rt.getmydrivercardapplcation.services.base;

import com.mystique.rt.getmydrivercardapplcation.models.Driver;

import java.io.IOException;
import java.util.List;

public interface DriverService {
    Driver addDriver(Driver driver) throws IOException;

    Driver getDriverById(int id) throws IOException;

    Driver getDriverByPersonalNumber(String personalNumber) throws IOException;

    List<Driver> getAllDrivers() throws IOException;

    Driver updateDriverById(int id, Driver driver) throws IOException;

    Driver getLastUpdatedDriver() throws IOException;
}

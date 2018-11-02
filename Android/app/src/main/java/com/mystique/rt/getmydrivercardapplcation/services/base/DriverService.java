package com.mystique.rt.getmydrivercardapplcation.services.base;

import com.mystique.rt.getmydrivercardapplcation.models.Driver;

import java.io.IOException;

public interface DriverService {
    Driver addDriver(Driver driver) throws IOException;

    Driver getDriverById(int id) throws IOException;

    Driver updateDriverById(int id, Driver driver) throws IOException;
}

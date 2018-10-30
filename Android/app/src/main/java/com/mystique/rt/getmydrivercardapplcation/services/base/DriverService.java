package com.mystique.rt.getmydrivercardapplcation.services.base;

import com.mystique.rt.getmydrivercardapplcation.models.Driver;

import java.io.IOException;

public interface DriverService {
    Driver add(Driver driver) throws IOException;

    Driver getById(int id) throws IOException;

    Driver updateById(int id, Driver driver) throws IOException;
}

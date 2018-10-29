package com.mystique.rt.getmydrivercardapplcation.repositories;

import com.mystique.rt.getmydrivercardapplcation.models.Driver;

import java.io.IOException;
import java.util.List;

public interface DriverRepository {

    Driver add(Driver driver) throws IOException;

    Driver getById(int id) throws IOException;

    Driver updateById(int id, Driver driver) throws IOException;
}

/**
 * <h1>DriverRepository interface</h1>
 *
 * <b>Description: </b> This interface defines the methods for the
 * repository layer (get, add, update) of Driver.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */


package com.mystique.rt.getmydrivercardapplcation.repositories.base;

import com.mystique.rt.getmydrivercardapplcation.models.Driver;

import java.io.IOException;
import java.util.List;

public interface DriverRepository {

    Driver add(Driver driver) throws IOException;

    Driver getById(int id) throws IOException;

    List<Driver> getAllDrivers() throws IOException;

    Driver updateById(int id, Driver driver) throws IOException;
}



package com.mystique.rt.getmydrivercardapplcation.services.base;

import com.mystique.rt.getmydrivercardapplcation.models.Driver;

import java.io.IOException;
import java.util.List;

/**
 * <h1>DriverService interface</h1>
 *
 * <b>Description: </b> This interface defines the methods for the
 * service layer (reflecting the business requirements of the
 * application) of Driver.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public interface DriverService {
    Driver addDriver(Driver driver) throws IOException;

    Driver getDriverById(int id) throws IOException;

    Driver getDriverByPersonalNumber(String personalNumber) throws IOException;

    List<Driver> getAllDrivers() throws IOException;

    Driver updateDriverById(int id, Driver driver) throws IOException;

    Driver getLastUpdatedDriver() throws IOException;
}

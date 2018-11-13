package com.mystique.springdrivercard.services.driverService;

import com.mystique.springdrivercard.models.Driver;

import java.util.List;
/**
 * <h1>DriverService interface</h1>
 *
 * <b>Description: </b> This interface defines the methods for the
 * service of Driver (reflecting the business requirements of the
 * application) .
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public interface DriverService {

    Driver addDriver(Driver driver);
    Driver getDriverByID(int id);
    List<Driver> getAllDrivers();
    Driver updateDriver(int id, Driver driver);

}

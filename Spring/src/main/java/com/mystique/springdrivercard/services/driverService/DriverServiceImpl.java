package com.mystique.springdrivercard.services.driverService;

import com.mystique.springdrivercard.models.Driver;
import com.mystique.springdrivercard.repositories.CardApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <h1>DriverServiceImpl class</h1>
 *
 * <b>Description: </b> This class implements the methods for the
 * service of Driver (reflecting the business requirements of the
 * application).
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
@Service
public class DriverServiceImpl implements DriverService {
    private CardApplicationRepository repository;

    @Autowired
    public DriverServiceImpl(CardApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Driver addDriver(Driver driver) {
        return repository.addDriver(driver);
    }

    @Override
    public Driver getDriverByID(int id) {
        return repository.getDriverByID(id);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return repository.getAllDrivers();
    }

    @Override
    public Driver updateDriver(int id, Driver driver) {
        return repository.updateDriver(id, driver);
    }
}

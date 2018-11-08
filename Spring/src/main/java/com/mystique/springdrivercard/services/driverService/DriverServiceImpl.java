package com.mystique.springdrivercard.services.driverService;

import com.mystique.springdrivercard.models.Driver;
import com.mystique.springdrivercard.repositories.CardApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

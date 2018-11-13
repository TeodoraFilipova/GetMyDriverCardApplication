package com.mystique.springdrivercard.controllers;

import com.mystique.springdrivercard.models.Driver;
import com.mystique.springdrivercard.services.driverService.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <h1>DriverController</h1>
 *
 * <b>Description: </b> This is a Rest Controller using the DriverService class which
 * defines requests to the "/api/drivers" URL and derived paths. Requests in this controller
 * are associated with the Driver model. It includes two(2) GET requests (get all and get by id),
 * a post request, and a put request.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    private DriverService driverService;

    @Autowired
    public DriverController(DriverService service) {
        this.driverService = service;
    }

    @PostMapping("/new")
    public Driver addDriver(@RequestBody Driver driver) {
        return driverService.addDriver(driver);
    }

    @GetMapping("/{id}")
    public Driver getDriverByID(@PathVariable int id) {
        return driverService.getDriverByID(id);
    }

    @GetMapping
    public List<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    @PutMapping("/{id}")
    public Driver updateDriver(@PathVariable int id, @RequestBody Driver driver) {
        return driverService.updateDriver(id, driver);
    }


}


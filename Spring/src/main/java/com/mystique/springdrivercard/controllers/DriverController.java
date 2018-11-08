package com.mystique.springdrivercard.controllers;

import com.mystique.springdrivercard.models.Driver;
import com.mystique.springdrivercard.services.driverService.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

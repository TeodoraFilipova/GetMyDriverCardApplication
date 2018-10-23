package com.mystique.springdrivercard.controllers;

import com.mystique.springdrivercard.models.Driver;
import com.mystique.springdrivercard.services.driverService.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    private DriverService driverService;

    @Autowired
    public DriverController(DriverService service) {
        this.driverService = service;
    }

    @PostMapping("/new")
    public void addDriver(@RequestBody Driver driver) {
        driverService.addDriver(driver);
    }

    @GetMapping("/{id}")
    public Driver getDriverByID(@PathVariable int id) {
        return driverService.getDriverByID(id);
    }

    @GetMapping("/{id}")
    public void updateDriver(@PathVariable int id, @RequestBody Driver driver) {
        driverService.updateDriver(id, driver);
    }



}

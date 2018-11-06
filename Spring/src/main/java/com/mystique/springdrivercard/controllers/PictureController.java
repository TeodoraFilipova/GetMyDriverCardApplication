package com.mystique.springdrivercard.controllers;


import com.mystique.springdrivercard.models.Picture;
import com.mystique.springdrivercard.services.driverService.DriverService;
import com.mystique.springdrivercard.services.pictureService.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pictures")
public class PictureController {

    private PictureService pictureService;

    @Autowired
    public PictureController(PictureService service) {
        this.pictureService = service;
    }

    @GetMapping("/{id}")
    public Picture getPictureByID(@PathVariable int id) {
        return pictureService.getPictureByID(id);
    }

    @GetMapping
    public List<Picture> getAllPictures() {
        return pictureService.getAllPictures();
    }

    @PostMapping("/new")
    public void addNewPicture(@RequestBody Picture picture) {
        pictureService.addNewPicture(picture);
    }

    @PutMapping("/{id}")
    public void updatePicture(@PathVariable int id, @RequestBody Picture picture) {
        pictureService.updatePicture(id, picture);
    }
}

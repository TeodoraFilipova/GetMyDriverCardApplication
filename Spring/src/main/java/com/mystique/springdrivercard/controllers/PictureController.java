package com.mystique.springdrivercard.controllers;


import com.mystique.springdrivercard.models.Picture;
import com.mystique.springdrivercard.services.driverService.DriverService;
import com.mystique.springdrivercard.services.pictureService.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <h1>PictureController</h1>
 *
 * <b>Description: </b> This is a Rest Controller using the PictureService class which
 * defines requests to the "/api/pictures" URL and derived paths. Requests in this controller
 * are associated with the Picture model. It includes two(2) GET requests (get all and get by id),
 * a post request, and a put request.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
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
    public Picture addNewPicture(@RequestBody Picture picture) {
        return pictureService.addNewPicture(picture);
    }

    @PutMapping("/{id}")
    public Picture updatePicture(@PathVariable int id, @RequestBody Picture picture) {
        return pictureService.updatePicture(id, picture);
    }
}

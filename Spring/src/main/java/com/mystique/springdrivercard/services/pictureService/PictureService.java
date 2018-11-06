package com.mystique.springdrivercard.services.pictureService;

import com.mystique.springdrivercard.models.Picture;

import java.util.List;

public interface PictureService {
    Picture getPictureByID(int id);

    List<Picture> getAllPictures();

    void addNewPicture(Picture picture);

    void updatePicture(int id, Picture picture);
}

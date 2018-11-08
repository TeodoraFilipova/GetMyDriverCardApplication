package com.mystique.springdrivercard.services.pictureService;

import com.mystique.springdrivercard.models.Picture;

import java.util.List;

public interface PictureService {
    Picture getPictureByID(int id);

    List<Picture> getAllPictures();

    Picture addNewPicture(Picture picture);

    Picture updatePicture(int id, Picture picture);
}

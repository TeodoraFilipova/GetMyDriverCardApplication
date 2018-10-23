package com.mystique.springdrivercard.services.pictureService;

import com.mystique.springdrivercard.models.Picture;

public interface PictureService {
    Picture getPictureByID(int id);

    void addNewPicture(Picture picture);

    void updatePicture(int id, Picture picture);
}

package com.mystique.rt.getmydrivercardapplcation.services.base;

import com.mystique.rt.getmydrivercardapplcation.models.Picture;

import java.io.IOException;

public interface PictureService {

    Picture addPicture(Picture picture) throws IOException;

    Picture getPictureById(int id) throws IOException;

    Picture updatePictureById(int id, Picture picture) throws IOException;
}

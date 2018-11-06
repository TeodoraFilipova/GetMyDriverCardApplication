package com.mystique.rt.getmydrivercardapplcation.repositories.base;

import com.mystique.rt.getmydrivercardapplcation.models.Picture;

import java.io.IOException;
import java.util.List;

public interface PictureRepository {

    Picture add(Picture picture) throws IOException;

    Picture getById(int id) throws IOException;

    List<Picture> getAllPictures() throws IOException;

    Picture updateById(int id, Picture picture) throws IOException;
}

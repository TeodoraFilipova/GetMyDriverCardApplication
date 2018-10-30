package com.mystique.rt.getmydrivercardapplcation.services.base;

import com.mystique.rt.getmydrivercardapplcation.models.Picture;

import java.io.IOException;

public interface PictureService {

    Picture add(Picture picture) throws IOException;

    Picture getById(int id) throws IOException;

    Picture updateById(int id, Picture picture) throws IOException;
}

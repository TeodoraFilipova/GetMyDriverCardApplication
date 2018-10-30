package com.mystique.rt.getmydrivercardapplcation.services;

import com.mystique.rt.getmydrivercardapplcation.models.Picture;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.PictureRepository;
import com.mystique.rt.getmydrivercardapplcation.services.base.PictureService;

import java.io.IOException;

public class HttpPictureService implements PictureService {
    private final PictureRepository mPictureRepository;

    public HttpPictureService(PictureRepository pictureRepository) {
        mPictureRepository = pictureRepository;
    }

    @Override
    public Picture add(Picture picture) throws IOException {
        return mPictureRepository.add(picture);
    }

    @Override
    public Picture getById(int id) throws IOException {
        return mPictureRepository.getById(id);
    }

    @Override
    public Picture updateById(int id, Picture picture) throws IOException {
        return mPictureRepository.updateById(id, picture);
    }
}

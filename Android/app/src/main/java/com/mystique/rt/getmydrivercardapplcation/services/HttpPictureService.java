package com.mystique.rt.getmydrivercardapplcation.services;

import com.mystique.rt.getmydrivercardapplcation.apputils.Constants;
import com.mystique.rt.getmydrivercardapplcation.models.Picture;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.PictureRepository;
import com.mystique.rt.getmydrivercardapplcation.services.base.PictureService;

import java.io.IOException;
import java.util.List;

public class HttpPictureService implements PictureService {
    private final PictureRepository mPictureRepository;

    public HttpPictureService(PictureRepository pictureRepository) {
        mPictureRepository = pictureRepository;
    }

    @Override
    public Picture addPicture(Picture picture) throws IOException {
        return mPictureRepository.add(picture);
    }

    @Override
    public Picture getPictureById(int id) throws IOException {
        return mPictureRepository.getById(id);
    }

    @Override
    public List<Picture> getAllPictures() throws IOException {
        return mPictureRepository.getAllPictures();
    }

    @Override
    public Picture getLastUpdatedPicture() throws IOException {
        List<Picture> allPictures = getAllPictures();
        for (Picture pic : allPictures) {
            if (pic.getLastSetID().equals(Constants.LAST_UPDATED_TRUE)) {
                return pic;
            }
        }
        return null;
    }

    @Override
    public Picture updatePictureById(int id, Picture picture) throws IOException {
        return mPictureRepository.updateById(id, picture);
    }
}

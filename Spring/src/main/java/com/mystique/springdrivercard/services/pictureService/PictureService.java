package com.mystique.springdrivercard.services.pictureService;

import com.mystique.springdrivercard.models.Picture;

import java.util.List;
/**
 * <h1>PictureService interface</h1>
 *
 * <b>Description: </b> This interface defines the methods for the
 * service of Picture(reflecting the business requirements of the
 * application).
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public interface PictureService {
    Picture getPictureByID(int id);

    List<Picture> getAllPictures();

    Picture addNewPicture(Picture picture);

    Picture updatePicture(int id, Picture picture);
}

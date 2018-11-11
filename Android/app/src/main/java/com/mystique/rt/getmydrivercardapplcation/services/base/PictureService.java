/**
 * <h1>PictureService interface</h1>
 *
 * <b>Description: </b> This interface defines the methods for the
 * service layer (reflecting the business requirements of the
 * application) of Picture.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.services.base;

import com.mystique.rt.getmydrivercardapplcation.models.Picture;

import java.io.IOException;
import java.util.List;

public interface PictureService {

    Picture addPicture(Picture picture) throws IOException;

    Picture getPictureById(int id) throws IOException;

    List<Picture> getAllPictures() throws IOException;

    Picture getLastUpdatedPicture() throws IOException;

    Picture updatePictureById(int id, Picture picture) throws IOException;
}

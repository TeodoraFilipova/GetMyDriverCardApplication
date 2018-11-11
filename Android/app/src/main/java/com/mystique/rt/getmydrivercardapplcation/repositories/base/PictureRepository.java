

package com.mystique.rt.getmydrivercardapplcation.repositories.base;

import com.mystique.rt.getmydrivercardapplcation.models.Picture;

import java.io.IOException;
import java.util.List;

/**
 * <h1>PictureRepository interface</h1>
 *
 * <b>Description: </b> This interface defines the methods for the
 * repository layer (get, add, update) of Picture.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public interface PictureRepository {

    Picture add(Picture picture) throws IOException;

    Picture getById(int id) throws IOException;

    List<Picture> getAllPictures() throws IOException;

    Picture updateById(int id, Picture picture) throws IOException;
}

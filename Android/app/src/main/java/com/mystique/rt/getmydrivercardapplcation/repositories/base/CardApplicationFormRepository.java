

package com.mystique.rt.getmydrivercardapplcation.repositories.base;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;

import java.io.IOException;
import java.util.List;

/**
 * <h1>CardApplicationFormRepository interface</h1>
 *
 * <b>Description: </b> This interface defines the methods for the
 * repository layer (get, add, update) of CardApplicationForm.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public interface CardApplicationFormRepository {
    List<CardApplicationForm> getAll() throws IOException;

    CardApplicationForm add(CardApplicationForm applicationForm) throws IOException;

    CardApplicationForm getById(int id) throws IOException;

    CardApplicationForm updateById(int id, CardApplicationForm applicationForm) throws IOException;
}

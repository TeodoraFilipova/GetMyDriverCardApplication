/**
 * <h1>UserRepository interface</h1>
 *
 * <b>Description: </b> This interface defines the methods for the
 * repository layer (get, add, update) of User.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.repositories.base;

import com.mystique.rt.getmydrivercardapplcation.models.User;

import java.io.IOException;
import java.util.List;

public interface UserRepository {
    List<User> getAll() throws IOException;

}

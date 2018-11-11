

package com.mystique.rt.getmydrivercardapplcation.services.base;

import com.mystique.rt.getmydrivercardapplcation.models.User;

import java.io.IOException;
import java.util.List;

/**
 * <h1>UserService interface</h1>
 *
 * <b>Description: </b> This interface defines the methods for the
 * service layer (reflecting the business requirements of the
 * application) of User.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public interface UserService {

    List<User> getAllUsers() throws IOException;

    User getUserByUsernameAndPassword(String userName, String password) throws IOException;
}

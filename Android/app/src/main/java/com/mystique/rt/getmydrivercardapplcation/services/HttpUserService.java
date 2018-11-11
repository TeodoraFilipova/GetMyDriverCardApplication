/**
 * <h1>HttpUserService class</h1>
 *
 * <b>Description: </b> This class implements the methods for the
 * service layer (reflecting the business requirements of the
 * application) of User.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.services;

import com.mystique.rt.getmydrivercardapplcation.models.User;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.UserRepository;
import com.mystique.rt.getmydrivercardapplcation.services.base.UserService;

import java.io.IOException;
import java.util.List;

public class HttpUserService implements UserService {
    private final UserRepository mUserRepository;

    public HttpUserService(UserRepository userRepository) {
        mUserRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        return mUserRepository.getAll();
    }

    @Override
    public User getUserByUsernameAndPassword(String userName, String password) throws IOException {
        List<User> allUsers = mUserRepository.getAll();
        for (User user : allUsers) {
            if (user.getUsername().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}

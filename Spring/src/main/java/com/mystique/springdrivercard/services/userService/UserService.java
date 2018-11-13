package com.mystique.springdrivercard.services.userService;

import com.mystique.springdrivercard.models.User;

import java.util.List;

/**
 * <h1>UserService interface</h1>
 *
 * <b>Description: </b> This interface defines the methods for the
 * service of User(reflecting the business requirements of the
 * application).
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public interface UserService {

    List<User> getAllUsers();
}

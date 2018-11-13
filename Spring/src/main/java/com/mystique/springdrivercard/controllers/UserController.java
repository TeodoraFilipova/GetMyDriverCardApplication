package com.mystique.springdrivercard.controllers;

import com.mystique.springdrivercard.models.User;
import com.mystique.springdrivercard.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h1>UserController</h1>
 *
 * <b>Description: </b> This is a Rest Controller using the UserService class which
 * defines requests to the "/api/users" URL and derived paths. Requests in this controller
 * are associated with the User model. It includes one(1) GET request (get all).
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService service) {
        this.userService = service;
    }

    @GetMapping
    public List<User> userList(){
        return userService.getAllUsers();
    }

}

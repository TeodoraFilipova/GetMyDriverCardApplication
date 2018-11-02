package com.mystique.rt.getmydrivercardapplcation.services.base;

import com.mystique.rt.getmydrivercardapplcation.models.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    List<User> getAllUsers() throws IOException;

    User getUserByUsernameAndPassword(String userName, String password) throws IOException;
}

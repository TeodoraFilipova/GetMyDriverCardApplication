package com.mystique.rt.getmydrivercardapplcation.repositories.base;

import com.mystique.rt.getmydrivercardapplcation.models.User;

import java.io.IOException;
import java.util.List;

public interface UserRepository {
    List<User> getAll() throws IOException;

}

/**
 * <h1>User Model class</h1>
 *
 * <b>Description: </b> This class is a model which corresponds to the model
 * with the same name in the Spring application. It is a POJO class with
 * constructors, getters, and setters.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.models;

import java.io.Serializable;

public class User implements Serializable {
    private int userId;
    private String username;
    private String password;

    public User() {
        // empty constructor
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

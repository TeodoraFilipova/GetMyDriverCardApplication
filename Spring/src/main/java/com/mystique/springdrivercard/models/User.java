package com.mystique.springdrivercard.models;


import javax.persistence.*;

/**
 * <h1>User model</h1>
 *
 * <b>Description: </b> This is a POJO class which acts as a model. It defines the fields/properties
 * of the User object. It includes relevant constructors, getters, and setters.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID", nullable = false)
    private int userId;

    @Column(name = "Username", nullable = false)
    private String username;

    @Column(name = "Password", nullable = false)
    private String password;

    public User(){}

    public User(String username, String password){
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

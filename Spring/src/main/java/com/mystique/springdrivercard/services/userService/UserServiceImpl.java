package com.mystique.springdrivercard.services.userService;

import com.mystique.springdrivercard.models.User;
import com.mystique.springdrivercard.repositories.CardApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <h1>UserServiceImpl class</h1>
 *
 * <b>Description: </b> This class implements the methods for the
 * service of User (reflecting the business requirements of the
 * application).
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
@Service
public class UserServiceImpl implements UserService {
    private CardApplicationRepository repository;

    @Autowired
    public UserServiceImpl(CardApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }
}

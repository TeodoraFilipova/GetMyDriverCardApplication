package com.mystique.springdrivercard.services.userService;

import com.mystique.springdrivercard.models.User;
import com.mystique.springdrivercard.repositories.CardApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

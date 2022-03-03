package com.example.springdataintrolab.services;

import com.example.springdataintrolab.exceptions.UserAlreadyExistsException;
import com.example.springdataintrolab.models.User;
import com.example.springdataintrolab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        if(userRepository.existsByUsername(user.getUsername())){
            throw new UserAlreadyExistsException();
        }
        userRepository.save(user);
    }
}

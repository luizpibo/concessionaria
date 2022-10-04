package com.easypantry.services;

import com.easypantry.entities.User;
import com.easypantry.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }
}

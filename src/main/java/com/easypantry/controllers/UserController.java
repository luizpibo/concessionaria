package com.easypantry.controllers;

import com.easypantry.entities.User;
import com.easypantry.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getAllUsers() {
        return userService.getAllUsers().toString();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId){
        return userService.findUserById(userId);
    }


}

package com.concessionaria.controllers;

import com.concessionaria.DTOs.UserDTO;
import com.concessionaria.entities.UserModel;
import com.concessionaria.services.User.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImplementation userServiceImplementation;
    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userServiceImplementation.getAllUsers());
    }
    @PostMapping("/create")
    public ResponseEntity<UserModel> createUser(@RequestBody @Validated UserDTO userDTO){
        System.out.println(userDTO);
        UserModel newUser = userServiceImplementation.createUser(userDTO);
        if(newUser != null){
            return  ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(newUser);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable(value = "id") UUID userId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userServiceImplementation.findUserById(userId));
    }


}

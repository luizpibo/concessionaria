package com.concessionaria.controllers;

import com.concessionaria.DTOs.UserDTO;
import com.concessionaria.entities.UserModel;
import com.concessionaria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.getAllUsers());
    }
    @PostMapping("/users/create")
    public ResponseEntity<UserModel> createUser(@RequestBody @Validated UserDTO userDTO){
        UserModel newUser = new UserModel();
        newUser = userService.save(userDTO);
        if(newUser != null){
            return  ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(newUser);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable(value = "id") UUID userId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.findUserById(userId));
    }


}

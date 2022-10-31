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
    public ResponseEntity<List<UserModel>> getAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userServiceImplementation.getAll());
    }
    @PostMapping("/create")
    public ResponseEntity<UserModel> create(@Validated @RequestBody UserDTO userDTO) throws Exception{
        UserModel newUser = userServiceImplementation.create(userDTO);
        return  new ResponseEntity(newUser, HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserModel> findById(@PathVariable(value = "id") UUID userId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userServiceImplementation.findById(userId));
    }


}

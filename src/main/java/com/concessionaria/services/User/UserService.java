package com.concessionaria.services.User;

import com.concessionaria.DTOs.UserDTO;
import com.concessionaria.entities.UserModel;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserModel> getAllUsers();
    UserModel findUserById(UUID id);
    UserModel createUser(UserDTO userdto);
    UserModel saveUser(UserModel userModel);
}

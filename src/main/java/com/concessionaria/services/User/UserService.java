package com.concessionaria.services.User;

import com.concessionaria.DTOs.UserDTO;
import com.concessionaria.entities.UserModel;
import com.concessionaria.exceptionhandler.UsernameExistsException;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserModel> getAll();
    UserModel findById(UUID id);
    UserModel create (UserDTO userdto) throws UsernameExistsException;
    UserModel update(UserDTO newUser, UUID id);
}

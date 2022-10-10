package com.concessionaria.services;

import com.concessionaria.DTOs.UserDTO;
import com.concessionaria.entities.UserModel;
import com.concessionaria.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getAllUsers(){
        return (List<UserModel>) userRepository.findAll();
    }

    public UserModel findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public UserModel save(UserDTO userDTO){
        var userModel= new UserModel();
        if(!userRepository.findByUsername(userDTO.getUsername()).isEmpty()){
            return null;
        }

        BeanUtils.copyProperties(userDTO, userModel);
        userModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

        return userRepository.save(userModel);
    }
}

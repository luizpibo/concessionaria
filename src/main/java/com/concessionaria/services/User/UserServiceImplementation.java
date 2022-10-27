package com.concessionaria.services;

import com.concessionaria.DTOs.UserDTO;
import com.concessionaria.entities.UserModel;
import com.concessionaria.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getAllUsers(){
        return (List<UserModel>) userRepository.findAll();
    }

    public UserModel findUserById(UUID id) {
        return userRepository.findById(id).get();
    }

    public  UserModel createUser(UserDTO userdto) throws UserAlreadyExistException{
        UserModel newUser = new UserModel();
        if(userRepository.findByUsername(userdto.getUsername()).isEmpty()){
            throw new UserAlreadyExistException("username already exists");
        }
        if(!userRepository.findByEmail(userdto.getEmail()).isEmpty()){
            return null;
        }
        BeanUtils.copyProperties(userdto, newUser);
        return saveUser(newUser);
    }
    public UserModel saveUser(UserModel userModel){
        return userRepository.save(userModel);
    }
}

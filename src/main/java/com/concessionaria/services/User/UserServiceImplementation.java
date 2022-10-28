package com.concessionaria.services.User;

import com.concessionaria.DTOs.UserDTO;
import com.concessionaria.entities.UserModel;
import com.concessionaria.exceptionhandler.UserNotFoundException;
import com.concessionaria.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImplementation implements  UserService{
    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Pegar todos os usuários
    public List<UserModel> getAll(){
        List<UserModel> users = userRepository.findAll();
        return users;
    }

    //Buscando usuário pelo id
    public UserModel findById(UUID id) {
        Optional<UserModel> user = userRepository.findById(id);
        return user.orElseThrow(() -> new UserNotFoundException());
    }

    public UserModel update(UserDTO newUser, UUID id){
        findById(id);
        UserModel updateUser = userRepository.findById(id).get();
        System.out.println("Updated user - "+updateUser.toString());
        BeanUtils.copyProperties(newUser, updateUser, "id");
        return userRepository.save(updateUser);
    }
    public  UserModel create(UserDTO userdto){
        UserModel newUser = new UserModel();
        if(userRepository.findByUsername(userdto.getUsername()).isEmpty()){
            return null;
        }
        if(!userRepository.findByEmail(userdto.getEmail()).isEmpty()){
            return null;
        }
        newUser.setUsername(userdto.getUsername());
        newUser.setEmail(userdto.getEmail());
        newUser.setPassword(passwordEncoder().encode(userdto.getPassword()));

        return userRepository.save(newUser);
    }
}

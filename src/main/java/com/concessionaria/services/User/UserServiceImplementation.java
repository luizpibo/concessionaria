package com.concessionaria.services.User;

import com.concessionaria.DTOs.UserDTO;
import com.concessionaria.entities.RoleModel;
import com.concessionaria.entities.UserModel;
import com.concessionaria.exceptionhandler.UserNotFoundException;
import com.concessionaria.exceptionhandler.UsernameExistsException;
import com.concessionaria.repositories.RoleRepository;
import com.concessionaria.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImplementation implements  UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

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
    public  UserModel create(UserDTO userdto) throws UsernameExistsException {
        System.out.println("Criando novo user -> "+userdto.getUsername()+" "+userdto.getEmail());
        if(!userRepository.findByUsername(userdto.getUsername()).isEmpty()){
            System.out.println("username igual");
            //throw new UsernameExistsException("There is an account with taht username adress: "+userdto.getUsername());
            return null;
        }
        if(!userRepository.findByEmail(userdto.getEmail()).isEmpty()){
            System.out.println("email igual");
            //throw new UsernameExistsException("There is an account with taht email adress: "+userdto.getEmail());
            return null;
        }

        UserModel newUser = new UserModel();
        RoleModel userRole = roleRepository.findByName("ROLE_USER");
        System.out.println("User role -> "+ userRole);

        newUser.setUsername(userdto.getUsername());
        newUser.setEmail(userdto.getEmail());
        newUser.setPassword(passwordEncoder().encode(userdto.getPassword()));
        newUser.setEnabled(true);
        newUser.setRoles(Arrays.asList(userRole));
        return userRepository.save(newUser);
    }
}

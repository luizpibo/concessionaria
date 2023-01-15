package com.concessionaria.services.User;

import com.concessionaria.DTOs.UserDTO;
import com.concessionaria.entities.RoleModel;
import com.concessionaria.entities.UserModel;
import com.concessionaria.exceptionhandler.exceptions.userController.EmailExistsException;
import com.concessionaria.exceptionhandler.exceptions.userController.UserNotFoundException;
import com.concessionaria.exceptionhandler.exceptions.userController.UsernameExistsException;
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
    @Override
    public List<UserModel> getAll(){
        List<UserModel> users = userRepository.findAll();
        return users;
    }
    //Buscando usuário pelo id
    @Override
    public UserModel findById(UUID id) {
        Optional<UserModel> user = userRepository.findById(id);
        return user.orElseThrow(() -> new UserNotFoundException());
    }
    @Override
    public UserModel update(UserDTO newUser, UUID id){
        findById(id);
        UserModel updateUser = userRepository.findById(id).get();
        System.out.println("Updated user - "+updateUser.toString());
        BeanUtils.copyProperties(newUser, updateUser, "id");
        return userRepository.save(updateUser);
    }
    @Override
    public  UserModel create(UserDTO userdto) throws UsernameExistsException, EmailExistsException {
        if(!userRepository.findByUsername(userdto.getUsername()).isEmpty()){
            System.out.println("username igual");
            throw new UsernameExistsException("There is an account with taht username adress: "+userdto.getUsername());
        }
        
        if(!userRepository.findByEmail(userdto.getEmail()).isEmpty()){
            System.out.println("email igual");
            throw new EmailExistsException("There is an account with taht email adress: "+userdto.getEmail());
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
    @Override
    public  UserDTO addRoleToUser(UUID userID, String RoleName) throws UsernameExistsException, EmailExistsException {
        var user = userRepository.findById(userID).get();
        if(user!=null){
            RoleModel role = roleRepository.findByName(RoleName);
            if(role != null){
                List<RoleModel> newRoleList = user.getRoles();
                if(!newRoleList.contains(role)){
                    newRoleList.add(role);
                    user.setRoles(newRoleList);
                }

            }
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

}

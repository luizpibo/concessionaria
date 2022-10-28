package com.concessionaria.security;

import com.concessionaria.entities.UserModel;
import com.concessionaria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel existsUser = userRepository.findByUsername(username).get();

        if(existsUser != null){
            throw new Error("Username does not exists!");
        }
        return UserPrincipal.create(existsUser);
    }
}

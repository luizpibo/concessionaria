package com.concessionaria.security;

import com.concessionaria.entities.UserModel;
import com.concessionaria.repositories.RoleRepository;
import com.concessionaria.repositories.UserRepository;
import com.concessionaria.services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service("userDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messages;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Username loadUserByUsername -> "+username);
        UserModel existsUser = userRepository.findByUsername(username).get();
        if(existsUser != null){
            throw new Error("Username does not exists!");
        }
        return UserPrincipal.create(existsUser);
    }

}






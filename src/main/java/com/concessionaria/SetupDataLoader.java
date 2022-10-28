package com.concessionaria;

import com.concessionaria.entities.PrivilegeModel;
import com.concessionaria.entities.RoleModel;
import com.concessionaria.entities.UserModel;
import com.concessionaria.repositories.PrivilegeRepository;
import com.concessionaria.repositories.RoleRepository;
import com.concessionaria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event){
        if(alreadySetup) return;

        PrivilegeModel readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        PrivilegeModel writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<PrivilegeModel> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        RoleModel adminRole = roleRepository.findByName("ROLE_ADMIN");
        UserModel user = new UserModel();

        user.setEmail("luiz@luiz.com");
        user.setUsername("luizpibo");
        user.setPassword(passwordEncoder.encode("teste"));
        user.setRoles(Arrays.asList(adminRole));
        userRepository.save(user);
         alreadySetup = true;

    }

    @Transactional
    PrivilegeModel createPrivilegeIfNotFound(String name){
        PrivilegeModel privilege = privilegeRepository.findByName(name);
        if(privilege == null){
            privilege = new PrivilegeModel(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    RoleModel createRoleIfNotFound(
            String name, List<PrivilegeModel> privileges
    ){
        RoleModel role = roleRepository.findByName(name);
        if(role == null){
            role = new RoleModel(name);
            role.setPrivilegeModels(privileges);
            roleRepository.save(role);
        }
        return role;
    }

}

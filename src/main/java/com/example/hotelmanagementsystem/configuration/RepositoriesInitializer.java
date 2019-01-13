package com.example.hotelmanagementsystem.configuration;

import com.example.hotelmanagementsystem.models.Role;
import com.example.hotelmanagementsystem.models.User;
import com.example.hotelmanagementsystem.repositories.RoleRepository;
import com.example.hotelmanagementsystem.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class RepositoriesInitializer {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    InitializingBean init(){
        return () -> {
            Role adminRole = new Role();
            adminRole.setType(Role.Types.ROLE_ADMIN);
            roleRepository.save(adminRole);

            Role clientRole = new Role();
            clientRole.setType(Role.Types.ROLE_CLIENT);
            roleRepository.save(clientRole);

            User u1 = new User();
            u1.setUsername("admin");
            u1.setPassword(bCryptPasswordEncoder.encode("admin"));
            u1.setRoles(new HashSet<>(Arrays.asList(adminRole)));
            userRepository.save(u1);

            User u2 = new User();
            u2.setUsername("client");
            u2.setPassword(bCryptPasswordEncoder.encode("client"));
            u2.setRoles(new HashSet<>(Arrays.asList(clientRole)));
            userRepository.save(u2);
        };
    }

}

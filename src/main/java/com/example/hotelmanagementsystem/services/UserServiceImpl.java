package com.example.hotelmanagementsystem.services;

import com.example.hotelmanagementsystem.models.Role;
import com.example.hotelmanagementsystem.models.User;
import com.example.hotelmanagementsystem.repositories.RoleRepository;
import com.example.hotelmanagementsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findRoleByType(Role.Types.ROLE_CLIENT);
        List roles = Arrays.asList(userRole);
        user.setRoles(new HashSet<>(roles));
        user.setConfirmPassword(null);
        userRepository.saveAndFlush(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

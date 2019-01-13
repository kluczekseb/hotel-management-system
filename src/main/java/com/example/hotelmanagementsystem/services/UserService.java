package com.example.hotelmanagementsystem.services;

import com.example.hotelmanagementsystem.models.User;

public interface UserService {

    void save(User user);
    User findByUsername(String username);
}

package com.example.hotelmanagementsystem.repositories;

import com.example.hotelmanagementsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}

package com.example.hotelmanagementsystem.repositories;

import com.example.hotelmanagementsystem.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByType(Role.Types type);
}

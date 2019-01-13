package com.example.hotelmanagementsystem.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Setter @Getter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Types type;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public enum Types{
        ROLE_ADMIN,
        ROLE_RECEPTION,
        ROLE_HUMANRESOURCES,
        ROLE_CLIENT
    }
}

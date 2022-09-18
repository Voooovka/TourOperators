package com.javovka.touragency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String username;
    private String lastname;
    private Date birthdate;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role roles;

}

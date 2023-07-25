package com.lwin.expense_tracker.entity.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USERS_TABLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String roles;

    public User (String email, String password, String roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}

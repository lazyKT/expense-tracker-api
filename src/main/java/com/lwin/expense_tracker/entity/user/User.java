package com.lwin.expense_tracker.entity.user;


import jakarta.persistence.*;

@Entity
@Table(name = "USER_TABLE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User {

    @Id
    @GeneratedValue
    private int userId;
    private String userEmail;
    private String joinedAt;
    private String updatedAt;
    private String avatarUrl;
}

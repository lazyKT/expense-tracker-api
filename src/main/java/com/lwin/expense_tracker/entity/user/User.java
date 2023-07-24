package com.lwin.expense_tracker.entity.user;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_TABLE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userEmail;
    private String joinedAt;
    private String updatedAt;
    private String avatarUrl;
    private String roles;

    public User (String userEmail, String joinedAt, String updatedAt, String avatarUrl) {
        this.userEmail = userEmail;
        this.joinedAt = joinedAt;
        this.updatedAt = updatedAt;
        this.avatarUrl = avatarUrl;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public String getAvatarUrl() { return this.avatarUrl; }

    public int getUserId() { return this.userId; }

    public String getRoles() { return this.roles; }
}

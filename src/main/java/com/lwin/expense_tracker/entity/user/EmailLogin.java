package com.lwin.expense_tracker.entity.user;


import com.lwin.expense_tracker.dto.user.EmailLoginDto;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class EmailLogin extends User {

    private String password;

    public EmailLogin (String email, String joinedAt, String updatedAt, String avatarUrl, String password) {
        super(email, joinedAt, updatedAt, avatarUrl);
        this.password = password;
    }

    public EmailLogin (EmailLoginDto dto) {
        super(dto.getUserEmail(), dto.getJoinedAt(), dto.getUpdatedAt(), dto.getAvatarUrl());
        this.password = dto.getPassword();
    }
}

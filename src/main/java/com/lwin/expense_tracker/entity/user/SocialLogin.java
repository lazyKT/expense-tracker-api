package com.lwin.expense_tracker.entity.user;


import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SocialLogin extends User {

    private String socialPlatform;

    public SocialLogin (String email, String joinedAt, String updatedAt, String avatarUrl, String socialPlatform) {
        super(email, joinedAt, updatedAt, avatarUrl);
        this.socialPlatform = socialPlatform;
    }
}

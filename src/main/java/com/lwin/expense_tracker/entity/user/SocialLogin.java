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
}

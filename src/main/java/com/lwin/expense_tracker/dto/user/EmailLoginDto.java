package com.lwin.expense_tracker.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class EmailLoginDto {

    @NotNull(message = "User email must not be null value")
    private String userEmail;

    @NotNull(message = "JoinedAt must not be null value")
    private String joinedAt;

    @NotNull(message = "Updated At must not be null value")
    private String updatedAt;

    @NotNull(message = "Avatar Url must not be null value")
    private String avatarUrl;

    @NotNull(message = "Password must not be null value")
    @Length(min = 8, message = "Password must have at least 8 characters")
    private String password;
}

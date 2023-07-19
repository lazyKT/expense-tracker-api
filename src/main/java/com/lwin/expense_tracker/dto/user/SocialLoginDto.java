package com.lwin.expense_tracker.dto.user;

import jakarta.validation.constraints.NotNull;

public class SocialLoginDto {

    @NotNull(message = "User email must not be null value")
    private String userEmail;

    @NotNull(message = "JoinedAt must not be null value")
    private String joinedAt;

    @NotNull(message = "Updated At must not be null value")
    private String updatedAt;

    @NotNull(message = "Avatar Url must not be null value")
    private String avatarUrl;

    @NotNull(message = "Social Platform must not be null value")
    private String socialPlatform;
}

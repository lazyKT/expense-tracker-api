package com.lwin.expense_tracker.dto.user;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotNull(message = "Email value must not be null")
    private String email;

    @NotNull(message = "Password must not be null value")
    private String password;

    @NotNull(message = "User roles must not be empty")
    private String roles;
}

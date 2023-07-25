package com.lwin.expense_tracker.controller;

import com.lwin.expense_tracker.dto.user.AuthRequest;
import com.lwin.expense_tracker.service.TokenService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController (TokenService tokenService, AuthenticationManager authManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authManager;
    }


    @PostMapping("/authenticate")
    public String authenticate (@RequestBody @Valid AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return tokenService.generateToken(authRequest.getEmail());
        }
        throw new UsernameNotFoundException("Invalid email or password!");
    }

}

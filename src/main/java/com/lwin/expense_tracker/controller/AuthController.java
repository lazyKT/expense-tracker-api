package com.lwin.expense_tracker.controller;

import com.lwin.expense_tracker.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService service;

    @Autowired
    public AuthController (TokenService service) {
        this.service = service;
    }


    @PostMapping("/token")
    public String token (Authentication authentication) {
        LOG.debug("Token requested for user: '{}'", authentication.getName());
        return service.generateToken(authentication);
    }
}

package com.lwin.expense_tracker.controller;


import com.lwin.expense_tracker.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    private static final Logger LOG = LoggerFactory.getLogger(TokenService.class);

    @GetMapping("")
    public String home(Principal principal) {
        return "Hello, " + principal.getName();
    }

    @GetMapping("test")
    public String test (Principal principal) {
        LOG.debug("HomeController::test::before::response");
        return "Hello, " + principal.getName();
    }
}

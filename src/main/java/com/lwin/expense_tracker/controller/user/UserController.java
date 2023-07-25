package com.lwin.expense_tracker.controller.user;


import com.lwin.expense_tracker.dto.user.AuthRequest;
import com.lwin.expense_tracker.entity.user.User;
import com.lwin.expense_tracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController (UserService service) {
        this.userService = service;
    }


    @PostMapping("/register")
    public String addNewUser (@RequestBody @Valid AuthRequest authRequest) {
        User user = new User(authRequest.getEmail(), authRequest.getPassword(), authRequest.getRoles());
        return userService.addUser(user);
    }
}

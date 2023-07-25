package com.lwin.expense_tracker.controller.user;


import com.lwin.expense_tracker.entity.user.User;
import com.lwin.expense_tracker.service.UserService;
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


    @PostMapping("/new")
    public String addNewUser (@RequestBody User user) {
        return userService.addUser(user);
    }
}

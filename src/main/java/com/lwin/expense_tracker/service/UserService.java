package com.lwin.expense_tracker.service;


import com.lwin.expense_tracker.entity.user.User;
import com.lwin.expense_tracker.exceptions.UserAlreadyExistedException;
import com.lwin.expense_tracker.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserService (UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public String addUser (User user) throws UserAlreadyExistedException {
        Optional<User> result = this.repository.findByEmail(user.getEmail());
        if (result.isPresent()) {
            throw new UserAlreadyExistedException("User account already existed with the same email, " + user.getEmail());
        }
        user.setPassword(encoder.encode(user.getPassword()));
        this.repository.save(user);
        return "New user added";
    }

    public User getUserByEmail (String email) {
        return this.repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email " + email));
    }

    public int getUserIdByEmail (String email) {
        User user = this.getUserByEmail(email);
        return user.getId();
    }
}

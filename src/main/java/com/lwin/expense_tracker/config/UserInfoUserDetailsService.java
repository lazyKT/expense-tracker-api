package com.lwin.expense_tracker.config;

import com.lwin.expense_tracker.entity.user.User;
import com.lwin.expense_tracker.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UserInfoUserDetailsService implements UserDetailsService {


    private final UserRepository repository;

    @Autowired
    public UserInfoUserDetailsService (UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = this.repository.findByEmail(email);

        return user.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email, " + email));
    }
}

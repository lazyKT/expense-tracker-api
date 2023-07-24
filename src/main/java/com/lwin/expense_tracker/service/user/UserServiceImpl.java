package com.lwin.expense_tracker.service.user;

import com.lwin.expense_tracker.dto.user.EmailLoginDto;
import com.lwin.expense_tracker.dto.user.SocialLoginDto;
import com.lwin.expense_tracker.entity.user.EmailLogin;
import com.lwin.expense_tracker.entity.user.SocialLogin;
import com.lwin.expense_tracker.entity.user.User;
import com.lwin.expense_tracker.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl {

    UserRepository repository;

    @Autowired
    public UserServiceImpl (UserRepository repository) {
        this.repository = repository;
    }


    public SocialLogin createSocialUser(SocialLoginDto socialLoginDto) {
        SocialLogin user = new SocialLogin(
            socialLoginDto.getUserEmail(),
            socialLoginDto.getJoinedAt(),
            socialLoginDto.getUpdatedAt(),
            socialLoginDto.getAvatarUrl(),
            socialLoginDto.getSocialPlatform()
        );
        return repository.save(user);
    }

    public EmailLogin createEmailLoginUser(EmailLoginDto emailLoginDto) {
        EmailLogin user = new EmailLogin(
          emailLoginDto.getUserEmail(),
          emailLoginDto.getJoinedAt(),
          emailLoginDto.getUpdatedAt(),
          emailLoginDto.getAvatarUrl(),
          emailLoginDto.getPassword()
        );
        return repository.save(user);
    }

    public EmailLogin login(String userEmail, String password) {
        Optional<EmailLogin> user = this.repository.findByUserEmail(userEmail);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        }
        throw new RuntimeException("Login failed!");
    }


    public User getUser(int userId) {
        return this.repository.findByUserId(userId);
    }

    public User updateUser(int userId, EmailLogin emailLogin) {
        User user = this.repository.findByUserId(userId);
        if (user instanceof EmailLogin) {
            ((EmailLogin) user).setPassword(emailLogin.getPassword());
            this.repository.save(user);
            return user;
        }
        throw new RuntimeException("Exception! Operation not allowed!");
    }


    public String uploadAvatar(int userId) {
        return null;
    }

}

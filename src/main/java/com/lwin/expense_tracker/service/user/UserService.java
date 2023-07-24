package com.lwin.expense_tracker.service.user;

import com.lwin.expense_tracker.dto.user.EmailLoginDto;
import com.lwin.expense_tracker.dto.user.SocialLoginDto;
import com.lwin.expense_tracker.entity.user.EmailLogin;
import com.lwin.expense_tracker.entity.user.SocialLogin;
import com.lwin.expense_tracker.entity.user.User;

public interface UserService {

    SocialLogin createSocialUser (SocialLoginDto socialLoginDto);

    EmailLogin createEmailLoginUser (EmailLoginDto emailLoginDto);

    EmailLogin login (String userEmail, String password);

    User getUser (int userId);

    User updateUser (int userId, EmailLogin emailLogin);

    String uploadAvatar (int userId);
}

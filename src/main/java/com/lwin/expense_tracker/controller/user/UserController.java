//package com.lwin.expense_tracker.controller.user;
//
//import com.lwin.expense_tracker.dto.user.EmailLoginDto;
//import com.lwin.expense_tracker.dto.user.SocialLoginDto;
//import com.lwin.expense_tracker.entity.user.EmailLogin;
//import com.lwin.expense_tracker.entity.user.SocialLogin;
//import com.lwin.expense_tracker.entity.user.User;
//import com.lwin.expense_tracker.service.user.UserServiceImpl;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("users")
//public class UserController {
//
//    private final UserServiceImpl service;
//
//    @Autowired
//    public UserController (UserServiceImpl service) {
//        this.service = service;
//    }
//
//    @PostMapping("/register")
//    @ResponseBody
//    public ResponseEntity<EmailLogin> registerUser (@RequestBody @Valid EmailLoginDto emailLoginDto) {
//        return new ResponseEntity<>(this.service.createEmailLoginUser(emailLoginDto), HttpStatus.CREATED);
//    }
//
//    @PostMapping("/social/register")
//    @ResponseBody
//    public ResponseEntity<SocialLogin> socialRegister (@RequestBody @Valid SocialLoginDto socialLoginDto) {
//        return new ResponseEntity<>(this.service.createSocialUser(socialLoginDto), HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{userId}")
//    @ResponseBody
//    public ResponseEntity<User> getUser (@PathVariable int userId) {
//        return ResponseEntity.ok(this.service.getUser(userId));
//    }
//
//    @PatchMapping("/{userId}")
//    @ResponseBody
//    public ResponseEntity<User> updateUser (@PathVariable int userId, @RequestBody @Valid EmailLoginDto dto) {
//        EmailLogin emailLogin = new EmailLogin(dto);
//        return ResponseEntity.ok(this.service.updateUser(userId, emailLogin));
//    }
//}

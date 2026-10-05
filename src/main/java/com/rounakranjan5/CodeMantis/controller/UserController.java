package com.rounakranjan5.CodeMantis.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/users/me")
    public OAuth2User getCurrentUser(@AuthenticationPrincipal OAuth2User user){
        return user;
    }

}

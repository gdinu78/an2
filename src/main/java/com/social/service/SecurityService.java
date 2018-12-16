package com.social.service;

import org.springframework.security.core.userdetails.User;

public interface SecurityService {
    String findLoggedInUsername();

    public User findLoggedInUser();

    void autologin(String username, String password);
}

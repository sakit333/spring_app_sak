package com.sak.Spring_signup.service;

import java.util.Optional;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.sak.Spring_signup.entity.User;

import jakarta.servlet.http.HttpSession;


public interface UserService {
    ModelAndView saveUser(User user);
    // String login(String userName, String password, ModelMap map, HttpSession session);
    Optional<User> authenticate(String userName, String password);
}

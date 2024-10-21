package com.sak.Spring_signup.service;

import org.springframework.web.servlet.ModelAndView;

import com.sak.Spring_signup.entity.User;

import java.util.List;


public interface UserService {
    ModelAndView saveUser(User user);
    User authenticate(String userName, String password);
    List<User> getAllUsers();
}

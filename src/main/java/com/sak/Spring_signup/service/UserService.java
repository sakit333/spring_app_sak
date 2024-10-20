package com.sak.Spring_signup.service;

import org.springframework.ui.ModelMap;

import jakarta.servlet.http.HttpSession;


public interface UserService {
    String login(String userName, String password, ModelMap map, HttpSession session);
}

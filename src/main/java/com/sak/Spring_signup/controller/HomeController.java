package com.sak.Spring_signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.sak.Spring_signup.entity.User;
import com.sak.Spring_signup.repository.UserRepository;


@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/signup")
    public String getsignup(@ModelAttribute User user) {
        userRepository.save(user);
        return "login";
    }

    @GetMapping("/signup")
    public String showsignup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }   
}

package com.sak.Spring_signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sak.Spring_signup.entity.User;
import com.sak.Spring_signup.repository.UserRepository;
import com.sak.Spring_signup.service.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/signup")
    public String showsignup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }  

    @PostMapping("/signup")
    public String getsignup(@ModelAttribute User user) {
        userRepository.save(user);
        return "login";
    }

    @GetMapping("/login")
    public String showlogin() {
        return "login";
    }

    @PostMapping("/login")
    public String getlogin(@RequestParam String userName, @RequestParam String password) {
        // return userService.login(userName, password, model, session);
        System.out.println("User Name: " + userName);
        System.out.println("Password: " + password);
        if(userName.equals("admin") && password.equals("admin")) {
            return "dashboard";
        }
        return "login";
    }
}

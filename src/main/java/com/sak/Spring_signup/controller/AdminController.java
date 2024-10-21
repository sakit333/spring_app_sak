package com.sak.Spring_signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sak.Spring_signup.repository.UserRepository;



@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin_dash")
    public ModelAndView adminDash() {
        return new ModelAndView("admin") ;
    }

    @GetMapping("/user_list")
    public ModelAndView userList() {
        ModelAndView model = new ModelAndView("user_list");
        model.addObject("users", userRepository.findAll());
        return model;
    }

    

}

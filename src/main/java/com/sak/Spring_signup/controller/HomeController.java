package com.sak.Spring_signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sak.Spring_signup.entity.User;
import com.sak.Spring_signup.service.UserService;


@RestController
@RequestMapping("/")
public class HomeController {

   @Autowired
   private UserService userService;
    
    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home");
    }
    

    @GetMapping("/signup")
    public ModelAndView showsignup(Model model) {
        model.addAttribute("user", new User());
        return new ModelAndView("signup");
    }  

    @PostMapping("/signup")
    public ModelAndView getsignup(@ModelAttribute User user) {
       return  userService.saveUser(user);
    }

    @GetMapping("/login")
    public ModelAndView showlogin() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView getlogin(@RequestParam String userName, @RequestParam String password) {
        User auth =userService.authenticate(userName, password);
        if(auth!=null) {
            return new ModelAndView("/user_dash");
        } 
        if(userName.equals("sak") && password.equals("sak1234")){
            return new ModelAndView("redirect:/admin/admin_dash");
        }
        else {
            return new ModelAndView("/login").addObject("error", "Invalid credentials. Please try again.");
        }
    }
}

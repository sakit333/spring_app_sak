package com.sak.Spring_signup.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sak.Spring_signup.entity.User;
import com.sak.Spring_signup.repository.UserRepository;
import com.sak.Spring_signup.service.UserService;

import jakarta.servlet.http.HttpSession;


// @Controller
@RestController
public class HomeController {

   @Autowired
   private UserService userService;
    
    @GetMapping("/")
    public ModelAndView home() {
        // return "home";
        return new ModelAndView("home");
    }

    @GetMapping("/signup")
    public ModelAndView showsignup(Model model) {
        model.addAttribute("user", new User());
        // return "signup";
        return new ModelAndView("signup");
    }  

    @PostMapping("/signup")
    public ModelAndView getsignup(@ModelAttribute User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/login")
    public ModelAndView showlogin() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView getlogin(@RequestParam String userName, @RequestParam String password) {
        Optional<User> auth =userService.authenticate(userName, password);
        if(auth!=null) {
            return new ModelAndView("redirect:/dashboard");
        }
        else {
            return new ModelAndView("redirect:/login");
        }
    }
}

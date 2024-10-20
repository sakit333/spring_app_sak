package com.sak.Spring_signup.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.sak.Spring_signup.entity.User;
import com.sak.Spring_signup.repository.UserRepository;
import com.sak.Spring_signup.service.UserService;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ModelAndView saveUser(User user) {
        
        userRepository.save(user);
        return new ModelAndView("login");
    }

    @Override
    public Optional<User> authenticate(String userName, String password) {
        return userRepository.findByUsernameAndPassword(userName, password);
    }
    

    // @Override
	// public String login(String userName, String password, ModelMap map, HttpSession session) {
    //     User user = userRepository.findByUserName(userName);
	// 	return "dashboard";
	// }

}

package com.sak.Spring_signup.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.sak.Spring_signup.entity.User;
import com.sak.Spring_signup.repository.UserRepository;
import com.sak.Spring_signup.service.UserService;

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
    public User authenticate(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName, password);
    }
    
}

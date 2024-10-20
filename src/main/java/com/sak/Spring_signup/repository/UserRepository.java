package com.sak.Spring_signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.servlet.ModelAndView;

import com.sak.Spring_signup.entity.User;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    // User findByUserName(String userName);
    User findByUserNameAndPassword(String userName, String password);

}

package com.sak.Spring_signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sak.Spring_signup.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserNameAndPassword(String userName, String password);
}

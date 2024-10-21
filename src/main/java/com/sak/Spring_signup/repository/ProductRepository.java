package com.sak.Spring_signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sak.Spring_signup.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}

package com.sak.Spring_signup.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sak.Spring_signup.entity.Product;
import com.sak.Spring_signup.repository.ProductRepository;
import com.sak.Spring_signup.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}


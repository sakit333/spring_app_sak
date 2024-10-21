package com.sak.Spring_signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sak.Spring_signup.entity.Product;
import com.sak.Spring_signup.repository.ProductRepository;
import com.sak.Spring_signup.repository.UserRepository;
import com.sak.Spring_signup.service.ProductService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

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

    @GetMapping("/logout")
    public ModelAndView logout() {
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/add_product")
    public ModelAndView showAddProductForm(Model model) {
        model.addAttribute("product", new Product()); // Add a new product object to the model
        return new ModelAndView("add_product"); // Return the view for adding a product
    }

    @PostMapping("/add_product")
    public ModelAndView addProduct(@ModelAttribute Product product) {
        productService.saveProduct(product); // Save the product using ProductService
        return new ModelAndView("redirect:/admin/add_product").addObject("success", "data stored successfully"); // Redirect to admin dashboard
    }

    @GetMapping("/get_product")
    public ModelAndView getProduct() {
        ModelAndView model =new ModelAndView("get_product");
        model.addObject("products", productRepository.findAll());
        return model;
    }
    
    @PostMapping("/delete_product/{id}")
    public ModelAndView deleteProduct(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
        return new ModelAndView("redirect:/admin/get_product");
    }
    
}

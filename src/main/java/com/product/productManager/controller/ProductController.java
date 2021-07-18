package com.product.productManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.product.productManager.domain.model.Product;
import com.product.productManager.domain.repository.ProductRepository;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/{id}", produces = "application/json")
    public Product getProduct(@PathVariable int id){
        return productRepository.findById(id).get();
    }

    @PostMapping(produces = "application/json")
    public Product newProduct(@RequestBody Product newProduct) {
        return productRepository.save(newProduct);
    }

    @DeleteMapping(produces = "application/json")
    public void removeProduct(@PathVariable int id) {
        productRepository.deleteById(id);
    }
}
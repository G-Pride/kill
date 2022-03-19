package com.example.seataproduct.controller;

import com.example.seataproduct.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/deduct")
    public HashMap deduct(@RequestParam Long productId) {
        return productService.deduct(productId);
    }
}

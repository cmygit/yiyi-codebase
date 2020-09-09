package org.example.business.controller;

import org.example.business.entity.Product;
import org.example.business.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/9 21:50
 */
@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private ProductService productService;

    @GetMapping("/hello")
    public ResponseEntity hello() {
        Product product = this.productService.getProduct();
        return ResponseEntity.ok(product);
    }
}

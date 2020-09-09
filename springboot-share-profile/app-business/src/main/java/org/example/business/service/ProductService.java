package org.example.business.service;

import org.example.business.entity.Product;
import org.example.business.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/9 22:30
 */
@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public Product getProduct() {
        return this.productMapper.selectById(1);
    }
}

package org.example.business.service;

import lombok.extern.slf4j.Slf4j;
import org.example.business.BusinessAppTest;
import org.example.business.entity.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/9 22:38
 */
@Slf4j
public class ProductServiceTest extends BusinessAppTest {

    @Autowired
    private ProductService service;

    @Test
    public void getProduct() {
        Product product = this.service.getProduct();
        assertNotNull(product);
        log.info(product.toString());
    }
}

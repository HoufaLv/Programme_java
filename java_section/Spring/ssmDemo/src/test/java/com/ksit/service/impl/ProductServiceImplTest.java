package com.ksit.service.impl;

import com.ksit.entity.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ProductServiceImplTest extends BaseTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void selectById() {
        System.out.println(productService.selectById(2179));
    }
}
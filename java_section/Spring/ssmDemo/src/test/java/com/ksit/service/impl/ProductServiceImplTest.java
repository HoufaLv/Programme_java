package com.ksit.service.impl;

import com.github.pagehelper.PageInfo;
import com.ksit.entity.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceImplTest extends BaseTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void selectById() {
        System.out.println(productService.selectById(2179));
    }

    @Test
    public void testSelectByPageNo(){
        PageInfo<Product> productPageInfo = productService.selectProductByPageNo(1);
        System.out.println(productPageInfo);

    }
}
package com.ksit.service;

import com.ksit.dao.ProductDao;

/**
 * 使用构造方法注入
 * @author Lvhoufa
 */
public class ProductService {

    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public ProductService() {
    }

    public void productDaoInsert(){
        productDao.insert();
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}

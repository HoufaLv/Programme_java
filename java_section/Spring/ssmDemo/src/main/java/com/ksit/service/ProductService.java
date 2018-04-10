package com.ksit.service;

import com.ksit.entity.Product;

/**
 * @author Lvhoufa
 */
public interface ProductService {

    /**
     * 根据id 查找对应的 Product
     * @param id        查询参数
     * @return          Product
     */
    Product selectById(Integer id);
}

package com.ksit.service.impl;

import com.ksit.entity.Product;
import com.ksit.mapper.ProductMapper;
import com.ksit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl  implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 根据id 查找对应的 Product
     *
     * @param id 查询参数
     * @return Product
     */
    @Override
    public Product selectById(Integer id) {
        return productMapper.selectById(id);
    }
}

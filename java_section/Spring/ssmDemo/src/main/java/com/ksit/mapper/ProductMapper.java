package com.ksit.mapper;


import com.ksit.entity.Product;

public interface ProductMapper {

    /**
     * 根据id 查找对应的 Product
     * @param id        查询参数
     * @return          Product
     */
    Product selectById(Integer id);
}

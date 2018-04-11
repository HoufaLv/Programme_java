package com.ksit.mapper;


import com.ksit.entity.Product;
import com.ksit.entity.ProductType;

import java.util.List;
import java.util.Map;

public interface ProductMapper {

    /**
     * 根据id 查找对应的 Product
     * @param id        查询参数
     * @return          Product
     */
    Product selectById(Integer id);


    /**
     * 连接两张表,查出Product 对应的 分类名字等信息
     * @return
     */
    List<Product> selectAllWithType();

    /**
     * 查出所有的分类信息
     * @return
     */
    List<ProductType> selectAllType();

    /**
     * 添加商品
     * @param product
     */
    void insertProduct(Product product);

    /**
     * 删除商品
     * @param id
     */
    void deleteProduct(Integer id);

    /**
     * 更新商品
     * @param product
     */
    void updateProduct(Product product);

    List<Product> selectProductByPageNoWithParamMap(Map<String, Object> paramsMap);
}

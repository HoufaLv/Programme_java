package com.ksit.mapper;

import com.ksit.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 尝试使用动态代理模式
 * @author Lvhoufa
 */
public interface ProductMapper {

    /**
     * 新增Product 方法
     * @param product
     * @return
     */
    int insert(Product product);

    /**
     * 根据id查询 对应对象
     * @param id    id
     * @return
     */
    Product queryById(int id);

    /**
     * 查询所有商品
     * @return
     */
    List<Product> queryAll();


    /**
     * 根据商品名和商品价格查找商品
     * @param productName
     * @param productPrice
     * @return
     */
    Product queryByNamePrice(@Param("productName") String productName,@Param("productPrice") String productPrice);
}

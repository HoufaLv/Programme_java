package com.ksit.service;

import com.github.pagehelper.PageInfo;
import com.ksit.entity.Product;
import com.ksit.entity.ProductType;

import java.util.List;
import java.util.Map;

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

    /**
     * 通过页号来查询产品信息
     * @param p         页号
     * @return
     */
    PageInfo<Product> selectProductByPageNo(Integer p);

    /**
     * 查询出所有的分类名称,然后将所有的分类信息传给前端
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
     * 更新商品信息
     * @param product
     */
    void updateProduct(Product product);

    /**
     * 根据页号和 参数动态查询
     * @param pageNo
     * @param paramsMap
     * @return
     */
    PageInfo<Product> selectProductByPageNoWithParamMap(Integer pageNo, Map<String, Object> paramsMap);
}

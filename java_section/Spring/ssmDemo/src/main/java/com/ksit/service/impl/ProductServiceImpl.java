package com.ksit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ksit.entity.Product;
import com.ksit.entity.ProductType;
import com.ksit.mapper.ProductMapper;
import com.ksit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

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

    /**
     * 通过页号来查询产品信息
     *
     * @param p 页号
     * @return
     */
    @Override
    public PageInfo<Product> selectProductByPageNo(Integer p) {
        /**
         * 设置页号和每页的数量
         */
        PageHelper.startPage(p, 20);

        /**
         * 通过连结查询查询出一个Product 和对应的分类信息,封装到一个List 中去
         */
        List<Product> productList = productMapper.selectAllWithType();


        /**
         * 会封装一个Page 对象传回去
         */
        return new PageInfo<>(productList);
    }

    /**
     * 查询出所有的分类名称,然后将所有的分类信息传给前端
     *
     * @return
     */
    @Override
    public List<ProductType> selectAllType() {
        return productMapper.selectAllType();
    }

    @Override
    public void insertProduct(Product product) {
        productMapper.insertProduct(product);
    }

    /**
     * 删除商品
     *
     * @param id
     */
    @Override
    public void deleteProduct(Integer id) {
        productMapper.deleteProduct(id);
    }

    /**
     * 更新商品信息
     *
     * @param product
     */
    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    /**
     * 根据页号和 参数动态查询
     *
     * @param pageNo
     * @param paramsMap
     * @return
     */
    @Override
    public PageInfo<Product> selectProductByPageNoWithParamMap(Integer pageNo, Map<String, Object> paramsMap) {
        //设置每页10 条数据
        PageHelper.startPage(pageNo,10);
        List<Product> productList = productMapper.selectProductByPageNoWithParamMap(paramsMap);
        return new PageInfo<>(productList);
    }

}

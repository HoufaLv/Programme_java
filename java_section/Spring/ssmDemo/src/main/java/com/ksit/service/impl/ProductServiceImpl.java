package com.ksit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.ksit.entity.Product;
import com.ksit.entity.ProductType;
import com.ksit.mapper.ProductMapper;
import com.ksit.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;

@Service
@CacheConfig(cacheNames = "products")
public class ProductServiceImpl implements ProductService {

    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private CacheManager cacheManager;


    /**
     * 根据id 查找对应的 Product
     *
     * @param id 查询参数
     * @return Product
     */
    @Override
    public Product selectById(Integer id) {

        final String KEY = "product" + id;
        Product product = null;
        Jedis jedis = jedisPool.getResource();

        //如果redis 中存在key 的话,从redis 中获取缓存,反序列化,将对象返回
        if (jedis.exists(KEY)){
            String json = jedis.get(KEY);
            product = new Gson().fromJson(json,Product.class);
            logger.info("select {} from redis -> " + product);
        }else{
            //如果不存在的话就去数据库中查一下,添加到缓存中去
            Product product1 = productMapper.selectById(id);
            if (product1!=null){
                jedis.set(KEY,new Gson().toJson(product1));
            }
            logger.info("select {} from DB ->" + id);
        }
        jedis.close();
        return product;
        //return productMapper.selectById(id);
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

package com.ksit.testMapper;

import com.ksit.entity.Product;
import com.ksit.mapper.ProductMapper;
import com.ksit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestMapperInterface {

    SqlSession sqlSession;
    ProductMapper productMapper;

    @Before
    public void init(){
        sqlSession = SqlSessionFactoryUtil.returnSqlSession(true);
        productMapper = sqlSession.getMapper(ProductMapper.class);
    }

    @Test
    public void testQueryById(){
        Product product = productMapper.queryById(10);
        System.out.println(product);
    }

    @Test
    public void testInsert(){
        int index = productMapper.insert(new Product("test6", "77.77"));
    }

    @Test
    public void testQueryAll(){
        for (Product product : productMapper.queryAll()) {
            System.out.println(product);
        }
    }

    @Test
    public void testQueryByNamePrice(){
        Product product = productMapper.queryByNamePrice("test1", "22.22");
        System.out.println(product);
    }

    @After
    public void release(){
        sqlSession.close();
    }

}

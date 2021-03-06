package com.ksit.test;

import com.ksit.entity.Product;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TestInsert {

    SqlSession sqlSession;

    @Before
    public void initSqlSessionFactory() throws IOException {
        sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatisConfig.xml")).openSession();
    }

    @Test
    public void testInsert() {
        Product product = new Product("test5", "66.66");
        sqlSession.insert("com.ksit.mapper.ProductMapper.insert", product);
        sqlSession.commit();
        System.out.println(product.getId());
    }

    @Test
    public void testQureyById() throws IOException {
        Object o = sqlSession.selectOne("com.ksit.mapper.ProductMapper.queryById",Integer.valueOf(9));
        System.out.println(o);
    }

    @After
    public void closeSqlSession(){
        sqlSession.close();
    }

    @Test
    public void testAmazing(){
        String s = DigestUtils.md5Hex("4297f44b13955235245b2497399d7a93password.salt");
        System.out.println(s);
    }

    @Test
    public void originCRUD() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

    }
}

package com.ksit.test;

import com.ksit.entity.Product;
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
        sqlSession.insert("com.ksit.mapper.ProductMapper.insert", new Product("test4", "55.55"));
        sqlSession.commit();
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
    public void originCRUD() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

    }
}

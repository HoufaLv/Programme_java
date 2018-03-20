package com.ksit.test;

import com.ksit.entity.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class TestInsert {

    @Test
    public void testInsert(){
        try {
            Product product = new Product("test3", "44.44");

            Reader reader = Resources.getResourceAsReader("mybatisConfig.xml");

            SqlSessionFactory sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);

            SqlSession sqlSession = sqlSessionFactory.openSession();

            sqlSession.insert("com.ksit.mappers.ProductMapper",new Product("test3", "44.44"));
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

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
            Reader reader = Resources.getResourceAsReader("mybatisConfig.xml");
            System.out.println(reader);

            SqlSessionFactory sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);
            System.out.println(sqlSessionFactory);

            SqlSession sqlSession = sqlSessionFactory.openSession();
            System.out.println(sqlSession);

            sqlSession.insert("com.ksit.mapper.ProductMapper",new Product("test3","44.44"));
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

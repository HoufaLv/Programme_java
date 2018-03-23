package com.ksit.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class SqlSessionFactoryUtilTest {

    @Test
    public void returnSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.returnSqlSessionFactory();
    }

    @Test
    public void returnSqlSession() {
        SqlSession sqlSession = SqlSessionFactoryUtil.returnSqlSession(true);
    }
}
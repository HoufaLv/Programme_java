package com.ksit.mapper;

import com.ksit.entity.Classs;
import com.ksit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClasssMapperTest {

    SqlSession sqlSession;
    ClasssMapper classsMapper;

    @Test
    public void queryById() {
        Classs classs = classsMapper.queryById(1);
        System.out.println(classs);
    }

    @Before
    public void init(){
        sqlSession = SqlSessionFactoryUtil.returnSqlSession(true);
        classsMapper = sqlSession.getMapper(ClasssMapper.class);
    }
}
package com.ksit.mapper;

import com.ksit.entity.Person;
import com.ksit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonMapperTest {

    SqlSession sqlSession;
    PersonMapper personMapper;

    @Before
    public void init() {
        sqlSession = SqlSessionFactoryUtil.returnSqlSession(true);
        personMapper = sqlSession.getMapper(PersonMapper.class);
    }

    @Test
    public void queryClassNameByPersonId() {
        Person person = personMapper.queryClassNameByPersonId(1);
        System.out.println(person);
    }

    @After
    public void release(){
        sqlSession.close();
    }
}
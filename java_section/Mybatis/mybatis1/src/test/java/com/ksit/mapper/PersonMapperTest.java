package com.ksit.mapper;

import com.ksit.entity.Classs;
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

   /* @Test
    public void queryClassNameByPersonId() {
        Person person = personMapper.queryClassNameByPersonId(1);
        System.out.println(person);
    }*/

  /*  @Test
    public void testQueryClassByPersonIdAnnotation(){
        Person person = personMapper.queryPersonIdAnnotation(1);
        System.out.println(person);

    }*/

  @Test
  public void testQueryClassByPersonIdAnnotation(){
      Person person = personMapper.queryClassByPersonIdAnnotation(1);
      System.out.println(person);
  }

   /* @Test
    public void testQueryById(){
        Classs classs = personMapper.queryById(1);
        System.out.println(classs);
    }
*/
    @After
    public void release(){
        sqlSession.close();
    }
}
package com.ksit.mapper;

import com.ksit.entity.Student;
import com.ksit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentMapperTest {

    SqlSession sqlSession;
    StudentMapper studentMapper;

    @Before
    public void init(){
        sqlSession = SqlSessionFactoryUtil.returnSqlSession(true);
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @Test
    public void findByIdWithTag() {
        Student student = studentMapper.findByIdWithTag(1);
        System.out.println(student);
    }

    @Test
    public void testFindStudentSchoolById(){
        Student student = studentMapper.findStudentSchoolById(1);
        System.out.println(student);
    }

    @Test
    public void testQueryAll(){
        for (Student student : studentMapper.queryAll()) {
            System.out.println(student);
        }
        ;
    }
}
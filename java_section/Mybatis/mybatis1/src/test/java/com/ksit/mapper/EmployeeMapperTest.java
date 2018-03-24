package com.ksit.mapper;

import com.ksit.entity.Employee;
import com.ksit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeMapperTest {

    SqlSession sqlSession;
    EmployeeMapper employeeMapper;

    @Before
    public void init(){
        sqlSession = SqlSessionFactoryUtil.returnSqlSession(true);
        employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
    }

    @Test
    public void testInsertEmployee(){
        employeeMapper.insertEmployee(new Employee("小红","女",23));
    }

    @After
    public void realease(){
        sqlSession.close();
    }

}
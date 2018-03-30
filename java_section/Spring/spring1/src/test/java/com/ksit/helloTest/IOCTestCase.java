package com.ksit.helloTest;

import com.ksit.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Enumeration;

public class IOCTestCase {

    @Test
    public void testStudentService(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");

        studentService.studentDaoSave();
    }
}

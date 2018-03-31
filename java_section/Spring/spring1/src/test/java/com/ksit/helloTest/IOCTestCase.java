package com.ksit.helloTest;

import com.ksit.service.AccountServicve;
import com.ksit.service.BasicTypeService;
import com.ksit.service.ProductService;
import com.ksit.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Enumeration;

public class IOCTestCase {
    ApplicationContext applicationContext;

    @Before
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testStudentService(){
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.studentDaoSave();
    }

    @Test
    public void testProductService(){
        ProductService productService = (ProductService) applicationContext.getBean("productService");
        productService.productDaoInsert();
    }

    @Test
    public void testBasicTypeService(){
        BasicTypeService basicTypeService = (BasicTypeService) applicationContext.getBean("basicTypeService");
        basicTypeService.showData();
    }

    @Test
    public void testAccountService(){
        AccountServicve accountServicve = (AccountServicve) applicationContext.getBean("accountService");
        accountServicve.accountDaoInsert();
    }
}

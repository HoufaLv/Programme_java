package com.ksit.service;

import com.ksit.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
/*@ContextConfiguration(locations = "classpath:applicationContext.xml")*/
@ContextConfiguration(classes = Application.class)
/*@ContextConfiguration*/
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserService(){
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = (UserService) applicationContext.getBean("userService");*/
        userService.insert();
        /*this.userService.insert();*/
    }

}
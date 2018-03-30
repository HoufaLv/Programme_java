package com.ksit.helloTest;

import com.ksit.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloTest {

    @Test
    public void tsetHelloWord(){
        // 尝试使用ClassPahtXmlAppplicationContext 来加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDaoAlias");
        userDao.insert();
    }

    @Test
    public void testFileSystemXmlApplicationContext(){
        // 尝试使用 FileSystemXmlApplicationContext 来加载配置文件
         ApplicationContext applicationContext = new FileSystemXmlApplicationContext("G:/test/FileSystemXmlApplicationContext/applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.insert();

    }
}

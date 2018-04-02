package com.ksit.proxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class Mp3Test {

    @Test
    public void testAOP(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Player player = (Player) applicationContext.getBean("mp3");

        player.play();
    }

}

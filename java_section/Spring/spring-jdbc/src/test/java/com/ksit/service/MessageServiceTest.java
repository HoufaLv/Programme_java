package com.ksit.service;

import com.ksit.entity.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MessageServiceTest {

    @Autowired
    MessageService messageService;

    /**
     * 测试spring的事务管用不管用
     */
    @Test
    public void insert() {

        messageService.insert(Arrays.asList(
                new Message("Message1T"),
                new Message("Message2T")
        ));
    }
}
package com.ksit.dao;

import com.ksit.entity.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MessageDaoTest {

    @Autowired
    MessageDao messageDao;

    @Test
    public void testInsert(){
        Message message = new Message("message19");
        messageDao.insert(message);
    }

    @Test
    public void testSelectByid(){
        Message message = messageDao.selectById(1);
        System.out.println(message);
    }

    @Test
    public void testCount(){
        System.out.println(messageDao.selectCount());
    }

    @Test
    public void testSelectAll(){
        for (Message message : messageDao.selectAll()) {
            System.out.println(message);
        }
    }

    @Test
    public void testSelectAllToMap(){
        for (Map<String, Object> stringObjectMap : messageDao.selectAllToMap()) {
            for (Map.Entry<String, Object> stringObjectEntry : stringObjectMap.entrySet()) {
                System.out.println(stringObjectEntry.getKey() + " -> " + stringObjectEntry.getValue());
            }
        }
    }

    @Test
    public void testUpdate(){
        Message message = new Message();
        message.setId(1);
        message.setMessage("messageTestUpdate1");
        messageDao.update(message);
    }

    @Test
    public void testBatchSave(){
        List<Message> messages = Arrays.asList(
                new Message("message23"),
                new Message("message24"),
                new Message("message25")
        );

        messageDao.batchSave(messages);
    }
}



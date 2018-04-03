package com.ksit.service;

import com.ksit.dao.MessageDao;
import com.ksit.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 使用@Transactional 来开启Spring 事务
 * @Transactional 也可以添加在方法的头上,标记这个方法使用事务
 */
@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    /**
     * 开启Spring  事务,在发生任何异常的情况下,都回滚事务
     * @param messageList 要保存的Message集合
     */
    @Transactional(isolation = Isolation.SERIALIZABLE,propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
    public void insert(List<Message> messageList){
        for (Message m :
                messageList) {
            messageDao.insert(m);
            /*throw  new RuntimeException("啊啊啊啊");*/
        }
    }
}

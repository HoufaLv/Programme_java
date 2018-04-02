package com.ksit.service;

import com.ksit.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public void insert(){
        userDao.insert();
    }
}

package com.ksit.service.impl;

import com.ksit.service.UserService;

public class UserServiceImpl implements UserService {

    public String getUserName(Integer id) {
        if (id.equals(1)){
            return "lili";
        }else{
            return "jack";
        }
    }

}

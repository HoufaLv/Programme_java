package com.ksit.service;

import com.ksit.dao.AccountDao;

public class AccountServicve {

    AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void accountDaoInsert(){
        accountDao.insert();
    }
}

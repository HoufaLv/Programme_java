package com.ksit.tms.service;

import com.ksit.tms.entity.Account;
import com.ksit.tms.exception.ServiceException;

/**
 * 账号相关的业务接口
 * @author Lvhoufa
 */
public interface AccountService {

    /**
     * 账户登陆方法
     * @param mobile            手机号 UQ
     * @param password          密码
     * @param loginIp           登陆ip
     * @return                   登陆成功的account 类
     * @throws ServiceException  登陆失败可能会引发业务异常
     */
    public Account login(String mobile,String password,String loginIp) throws ServiceException;

    /**
     * 添加账户
     * @param account       账户
     * @param rolesIds      roles id
     */
    void insertAccount(Account account, Integer[] rolesIds);
}

package com.ksit.tms.service;

import com.ksit.tms.entity.Account;
import com.ksit.tms.entity.Roles;
import com.ksit.tms.exception.ServiceException;

import java.util.List;
import java.util.Map;

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

    /**
     * 动态查询,拼装sql
     * @param requestParam
     * @return
     */
    Object findAllAccountWithRolesByQueryParam(Map<String, Object> requestParam);

    /**
     * 根据id 删除账户
     * @param id
     */
    void deleteAccount(Integer id);

    /**
     * 根据id 查询账户
     * @param id
     * @return
     */
    Account selectById(Integer id);

    /**
     * 根据id来查询账户对应的角色
     * @param id
     * @return
     */
    List<Roles> selectRolesByAccountId(Integer id);
}

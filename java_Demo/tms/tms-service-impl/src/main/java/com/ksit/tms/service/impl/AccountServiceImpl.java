package com.ksit.tms.service.impl;

import com.ksit.tms.entity.Account;
import com.ksit.tms.entity.AccountExample;
import com.ksit.tms.entity.AccountLoginLog;
import com.ksit.tms.entity.AccountRolesKey;
import com.ksit.tms.exception.ServiceException;
import com.ksit.tms.mapper.AccountLoginLogMapper;
import com.ksit.tms.mapper.AccountMapper;
import com.ksit.tms.mapper.AccountRolesMapper;
import com.ksit.tms.mapper.RolesMapper;
import com.ksit.tms.service.AccountService;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 账号相关的业务实现类
 *
 * @author Lvhoufa
 */
@Service
public class AccountServiceImpl implements AccountService {

    /**
     * 将会自动注入 mapper实现类
     */
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AccountLoginLogMapper accountLoginLogMapper;
    @Autowired
    private RolesMapper rolesMapper;
    @Autowired
    private AccountRolesMapper accountRolesMapper;

    /**
     * 记录日志
     */
    public static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    /**
     * 账户登陆方法
     *
     * @param mobile   手机号 UQ
     * @param password 密码
     * @param loginIp  登陆ip
     * @return 登陆成功的account 类
     * @throws ServiceException 登陆失败可能会引发业务异常
     */
    @Override
    public Account login(String mobile, String password, String loginIp) throws ServiceException {
        //接收前端数据,去后代做对比,查到账户就是登陆成功,否则就是登陆失败
        Account account = null;

        //根据手机号做查找功能
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andAccountMobileEqualTo(mobile);

        List<Account> accounts = accountMapper.selectByExample(accountExample);

        //如果查出来的数据是正常的话
        if (accounts != null && !(accounts.size() == 0)) {
            //取出查出来的 account
            account = accounts.get(0);
            System.out.println(DigestUtils.md5Hex(password));

            //判断密码正否正确
            if (account.getAccountPassword().equals(DigestUtils.md5Hex(password))) {
                //如果用户的状态不正常
                if (!(Account.ACCOUNT_NORMAL.equals(account.getAccountState()))) {
                    throw new ServiceException("用户状态" + account.getAccountState());
                }else {

                    //验证通过,添加日志
                    AccountLoginLog accountLoginLog = new AccountLoginLog(loginIp, new Date(), account.getId());
                    logger.debug("{} 登陆了系统.", accountLoginLog);
                    accountLoginLogMapper.insertSelective(accountLoginLog);
                    return account;
                }
            } else {
                throw new ServiceException("账号或密码错误");
            }
        } else {
            throw new ServiceException("账号或密码错误");
        }
    }

    /**
     * 添加账户
     *
     * @param account  账户
     * @param rolesIds roles id
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void insertAccount(Account account, Integer[] rolesIds) {
        account.setCreateTime(new Date());
        //为账号设置密码,默认为000000
        account.setAccountPassword(DigestUtils.md5Hex(Account.PAASWORD));
        account.setAccountState(Account.ACCOUNT_NORMAL);
        accountMapper.insert(account);

        //增加关联关系
        for (Integer i : rolesIds) {
            AccountRolesKey accountRolesKey = new AccountRolesKey();
            accountRolesKey.settAccountId(account.getId());
            accountRolesKey.settRolesId(i);
            accountRolesMapper.insert(accountRolesKey);
        }

        logger.info("添加账户{}",account);

    }
}

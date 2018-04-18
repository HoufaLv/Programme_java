package com.ksit.tms.shiro;


import com.ksit.tms.entity.Account;
import com.ksit.tms.entity.AccountLoginLog;
import com.ksit.tms.service.AccountService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


/**
 * 自定义领域 继承 AuthorizingRealm 抽象类,因为这个抽象类可以自动判断权限和角色
 *
 * @author Lvhoufa
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    AccountService accountService;

    private static Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    /**
     * 判断是否授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 判断是否通过身份验证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //usernamePasswordToken 是 AuthenticationToken 的实现类,接口指向实现类
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String userMobile = usernamePasswordToken.getUsername();
        System.out.println("userMobile = " + userMobile);

        //判断登陆
        if (userMobile != null) {
            Account account = accountService.selectByMobile(userMobile);

            //对账号的各种状态做捕获
            if (account != null) {

                if (Account.ACCOUNT_NORMAL.equals(account.getAccountState())) {
                    //记录登陆日志,记录登陆账号和 ip地址
                    logger.info("登陆综合管理系统{},ip地址为: ",account,usernamePasswordToken.getHost().toString());

                    //将登陆信息保存到数据库中去
                    AccountLoginLog accountLoginLog = new AccountLoginLog();
                    accountLoginLog.setAccountId(account.getId());
                    accountLoginLog.setLoginIp(usernamePasswordToken.getHost());
                    accountLoginLog.setLoginTime(new Date());
                    accountService.insertAccountLoginLog(accountLoginLog);

                    //会自动进行校验,这里的密码要注意是否在Controller 中进行加密了
                    //在页面使用shiro 标签库的时候,property 就是这个里面的参数
                    return new SimpleAuthenticationInfo(account,account.getAccountPassword(),getName());

                } else {
                    throw new LockedAccountException("账户状态异常");
                }
            } else {
                throw new UnknownAccountException("未发现账户");
            }
        }
        return null;
    }
}

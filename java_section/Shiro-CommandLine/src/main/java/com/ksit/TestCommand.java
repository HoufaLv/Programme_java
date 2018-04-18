package com.ksit;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @author Lvhoufa
 */
public class TestCommand {

    public static void main(String[] args) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        //获取Subject(账户)对象
        Subject subject = SecurityUtils.getSubject();

        //显示为未登陆,检测是否通过身份验证了
        System.out.println("isAuthenticated? " + subject.isAuthenticated());

        //如果没有通过身份验证的话,使用UserPasswordToken 去尝试登陆
        if (!subject.isAuthenticated()){
            //如果账号密码不正确,则会抛出不正确的凭证异常
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhangsan", "123123");
            try {
                subject.login(usernamePasswordToken);
            } catch (UnknownAccountException ex) {
                System.out.println("UnknownAccountException");
            } catch (IncorrectCredentialsException ex) {
                System.out.println("IncorrectCredentialsException");
            } catch (LockedAccountException ex) {
                System.out.println("LockedAccountException");
            } catch (AuthenticationException ex) {
                System.out.println("AuthenticationException");
            }
        }

    }
}

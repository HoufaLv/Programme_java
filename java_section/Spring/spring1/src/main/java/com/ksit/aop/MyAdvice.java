package com.ksit.aop;

import org.aspectj.lang.JoinPoint;

public class MyAdvice {

    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("前置通知");
    }

    public void afterAdvice(Object result){
        System.out.println("后置通知" + result);
    }

    public void exceptionAdive(Exception ex){
        System.out.println("异常通知" + ex.getMessage());
    }

    public void finalAdvice(){
        System.out.println("最终通知");
    }
}

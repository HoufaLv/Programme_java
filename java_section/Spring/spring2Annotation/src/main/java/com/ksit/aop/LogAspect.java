package com.ksit.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 使用注解配置通知类
 * 不在配置文件中添加 开启基于注解的aop 是无法开启基于注解的通知的
 */
@Component
@Aspect
public class LogAspect {


    /**
     * 配置切入点
     */
    @Pointcut("execution(* com.ksit.service.*.*(..))")
    public void pointCut(){}

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before(value = "pointCut()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("LogAspect.beforeAdvice" + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "pointCut()",returning = "object")
    public void afterReturningAdvice(JoinPoint joinPoint,Object object){
        System.out.println("LogAspect.afterAdvice" + joinPoint.getSignature().getName() + object);
    }

    @AfterThrowing( value = "pointCut()",throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint,Exception ex){
        System.out.println("LogAspect.afterThrowing" + joinPoint.getSignature().getName() + ex.getMessage());
    }

    @After(value = "pointCut()")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("LogAspect.afterAdvice" + joinPoint.getSignature().getName());
    }

}

package com.ksit.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvoketionHandler implements InvocationHandler {

    Object target;

    public MyInvoketionHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //再这个方法里做什么
        Object invoke = method.invoke(target, args);

        return invoke;
    }
}

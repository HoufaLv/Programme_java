package com.ksit.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

public class SaleProxyTest {

    @Test
    public void sale() {
        SaleProxy saleProxy = new SaleProxy();
        saleProxy.sale();
    }

    @Test
    public void testCGlib(){
        Enhancer enhancer = new Enhancer();

        //设置目标对象
        enhancer.setSuperclass(Sales.class);

        //设置目标对象的代理行为
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * @param obj       目标对象
             * @param method    目标方法
             * @param args      方法参数
             * @param proxy     产生的子类方法代理
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

                Object result = null;

                try {
                    System.out.println("SaleProxyTest.intercept.before");
                    result = proxy.invokeSuper(obj, args);
                    System.out.println("SaleProxyTest.intercept.after");
                } catch (Throwable throwable) {
                    System.out.println("SaleProxyTest.intercept.exception");
                    throwable.printStackTrace();
                } finally {
                    System.out.println("SaleProxyTest.intercept.finally");
                }

                return result;
            }
        });

        Sales sales = (Sales) enhancer.create();
        sales.sale();
    }
}
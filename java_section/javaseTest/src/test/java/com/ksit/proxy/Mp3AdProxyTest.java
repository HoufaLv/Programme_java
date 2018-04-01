package com.ksit.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class Mp3AdProxyTest {

    @Test
    public void testMp3AdProxy(){

        Mp3 mp3 = new Mp3();
        Mp3AdProxy mp3AdProxy = new Mp3AdProxy(mp3);
        mp3AdProxy.play("广告代理类播放音乐");
        mp3AdProxy.stop();

    }

    @Test
    public void testJdkProxy(){
        //创建目标对象
        final Mp3 mp3 = new Mp3();
        //获得目标对象的类加载器
        ClassLoader classLoader = mp3.getClass().getClassLoader();
        //获得目标对象的接口数组
        Class<?>[] interfaces = mp3.getClass().getInterfaces();

        Player player = (Player) Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            /**
             * @param proxy     正在执行的代理对象
             * @param method    客户调用的方法(目标对象的方法)
             * @param args      方法的参数列表
             * @return 方法的返回值
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                System.out.println("方法" +methodName+ "开始调用");
                Object result = method.invoke(mp3, args);
                System.out.println("方法" +methodName+ "调用结束");

                return result;
            }
        });


        player.play("歌曲");
        player.stop();
    }

}
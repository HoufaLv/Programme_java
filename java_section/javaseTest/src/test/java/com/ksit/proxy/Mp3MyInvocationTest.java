package com.ksit.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class Mp3MyInvocationTest {


    @Test
    public void testMyInnocationHandler(){

        Mp3 mp3 = new Mp3();

        MyInvocation myInvocation = new MyInvocation(mp3);

        Player player = (Mp3) Proxy.newProxyInstance(myInvocation.getClass().getClassLoader(), myInvocation.getClass().getInterfaces(), myInvocation);

        player.play("音乐名称");

        player.stop();
    }
}

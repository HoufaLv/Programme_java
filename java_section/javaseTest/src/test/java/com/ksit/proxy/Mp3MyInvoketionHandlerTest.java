package com.ksit.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class Mp3MyInvoketionHandlerTest {

    @Test
    public void testMyInvoketionHandler(){
        Mp3 mp3 = new Mp3();

        MyInvoketionHandler myInvoketionHandler = new MyInvoketionHandler(mp3);

        Player player = (Player) Proxy.newProxyInstance(myInvoketionHandler.getClass().getClassLoader(),myInvoketionHandler.getClass().getInterfaces(),myInvoketionHandler);

        player.play("音乐名称");

        player.stop();
    }
}

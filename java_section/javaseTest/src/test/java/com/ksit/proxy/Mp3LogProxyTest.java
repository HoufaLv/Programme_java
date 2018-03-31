package com.ksit.proxy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Mp3LogProxyTest {

    @Test
    public void testMa3LogProxy(){
        Mp3 mp3 = new Mp3();

        Mp3LogProxy mp3LogProxy = new Mp3LogProxy(mp3);
        mp3LogProxy.play("代理类播放音乐");
        mp3LogProxy.stop();

    }

}
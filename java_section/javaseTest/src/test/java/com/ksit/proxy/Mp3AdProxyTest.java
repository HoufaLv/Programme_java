package com.ksit.proxy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Mp3AdProxyTest {

    @Test
    public void testMp3AdProxy(){

        Mp3 mp3 = new Mp3();
        Mp3AdProxy mp3AdProxy = new Mp3AdProxy(mp3);
        mp3AdProxy.play("广告代理类播放音乐");
        mp3AdProxy.stop();
        
    }

}
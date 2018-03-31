package com.ksit.proxy;

/**
 * mp3 广告代理类
 * @author Lvhoufa
 */
public class Mp3AdProxy implements Player {

    Player target;

    public Mp3AdProxy() { }

    public Mp3AdProxy(Player target) {
        this.target = target;
    }

    @Override
    public void play(String musicName) {
        System.out.println("Mp3AdProxy.play");
        target.play(musicName);
    }

    @Override
    public void stop() {
        System.out.println("Mp3AdProxy.stop");
    }
}

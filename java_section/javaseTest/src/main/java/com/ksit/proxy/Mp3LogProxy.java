package com.ksit.proxy;

/**
 * Mp3日志代理类
 * @author Lvhoufa
 */
public class Mp3LogProxy implements Player {

    Player target;

    public Mp3LogProxy() { }

    public Mp3LogProxy(Player target) {
        this.target = target;
    }

    @Override
    public void play(String musicName) {
        //增加代理类自己的行为
        System.out.println("Mp3LogProxy.play");
        target.play(musicName);
    }

    @Override
    public void stop() {
        System.out.println("Mp3LogProxy.stop");
        //增加代理类自己的行为
    }
}

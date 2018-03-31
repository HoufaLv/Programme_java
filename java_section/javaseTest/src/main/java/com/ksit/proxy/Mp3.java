package com.ksit.proxy;

public class Mp3 implements Player {

    @Override
    public void play(String musicName) {
        System.out.println("Mp3.play" + musicName);
    }

    @Override
    public void stop() {
        System.out.println("Mp3.stop");
    }
}

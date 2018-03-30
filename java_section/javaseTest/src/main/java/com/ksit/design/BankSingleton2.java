package com.ksit.design;

/**
 * 单例模式
 * 饿汉式
 */
public class BankSingleton2 {

    private BankSingleton2() { }

    private static  BankSingleton2 bankSingleton2 = new BankSingleton2();

    public static BankSingleton2 getInstance(){
        return bankSingleton2;
    }
    
}

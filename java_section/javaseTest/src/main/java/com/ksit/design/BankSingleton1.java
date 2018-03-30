package com.ksit.design;

/**
 * 懒汉式
 * @author Lvhoufa
 */
public class BankSingleton1 {

    /**
     * 私有化构造函数
     */
    private void BankSingletion1(){}

    private static BankSingleton1 bankSingleton1;

    //懒汉式,就是不创建实例,等到有请求的时候再去创建实例

    public static BankSingleton1 getInstance(){
        if (bankSingleton1==null){
            bankSingleton1 = new BankSingleton1();
            return bankSingleton1;
        }
        return null;
    }

}

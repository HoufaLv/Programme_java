package com.ksit.equalsWith;

public class EqualsWith {
    public static void main(String[] args) {
        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(1);

        //对于引用类型 == 判断的是内存地址,是否引用同一对象,由于两个integer 是new 出来的,所以其内存地址肯定不一样
        System.out.println(integer1 == integer2);
        //对于引用类型, 使用equals 判断的是值相等不相等
        System.out.println(integer1.equals(integer2));
    }
}

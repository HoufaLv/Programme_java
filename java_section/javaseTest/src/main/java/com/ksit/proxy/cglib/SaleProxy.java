package com.ksit.proxy.cglib;

public class SaleProxy extends Sales {

    @Override
    void sale() {
        System.out.println("SaleProxy.sale.before");
        super.sale();
        System.out.println("SaleProxy.sale.after");
    }
}

package com.yu.adapter;

/**
 * 因为通过对象实现，所以属于对象适配器方式
 * 适配器
 * @author pengyu
 */
public class Adapter2  implements Target{

    Adaptee adaptee = new Adaptee();
    @Override
    public void handleReq() {
        adaptee.request();
    }

    public Adapter2(Adaptee adaptee) {
        super();
        this.adaptee = adaptee;
    }
}

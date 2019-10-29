package com.yu.adapter;

/**
 * 因为通过继承实现的，所以属于类适配器方式
 * 适配器
 * @author pengyu
 */
public class Adapter  extends Adaptee implements Target{

    @Override
    public void handleReq() {
        super.request();
    }

}

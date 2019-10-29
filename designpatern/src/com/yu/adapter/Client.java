package com.yu.adapter;

/**
 * 客户端
 * 相当于只有usb接口的笔记本
 * @author pengyu
 */
public class Client {

    public void test1(Target target) {
        target.handleReq();
    }

    public static void main(String[] args) {

        // 客户端
        Client client = new Client();

        // 需要适配的类
        Adaptee adaptee = new Adaptee();

        //适配器

        // Target target = new Adapter();
        Target target2 = new Adapter2(adaptee);

        // client.test1(target);
        client.test1(target2);
    }
}

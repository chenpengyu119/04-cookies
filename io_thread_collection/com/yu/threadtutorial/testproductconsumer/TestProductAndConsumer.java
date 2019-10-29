package com.yu.threadtutorial.testproductconsumer;

/**
 * 生产者消费者测试类
 * @author pengyu
 */
public class TestProductAndConsumer {

    public static void main(String[] args) {
        Goods goods = new Goods();
        Productor productor = new Productor(goods);
        Consumer consumer = new Consumer(goods);


        Thread productorThread = new Thread(productor);
        Thread consumerThread = new Thread(consumer);

        productorThread.start();
        consumerThread.start();
    }
}

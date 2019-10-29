package com.yu.threadtutorial.stronger.productandconsume3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者消费者问题升级版
 * 多个生产者多个消费者多个商品
 *
 *
 *
 *
 * @author pengyu
 */
public class TestProductAndConsumer {

    public static void main(String[] args) {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        GoodsFactory factory = new GoodsFactory(queue);

        for (int i = 0; i < 5; i++) {
            new Thread(new Produtor(factory)).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Consumer(factory)).start();
        }

    }


}

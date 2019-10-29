package com.yu.threadtutorial.stronger.productandconsume3;

import java.util.concurrent.BlockingQueue;

/**
 * 商品生产工厂
 *
 * @author pengyu
 */
public class GoodsFactory {

    private BlockingQueue<String> queue ;

    public GoodsFactory(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public  void product(String name) throws InterruptedException {
            queue.put(name);
            System.out.println(Thread.currentThread().getName() + "生产商品:" + name + ",当前商品数量：" + queue.size());
    }

    public  void consume(String name) throws InterruptedException {


                queue.take();
                System.out.println(Thread.currentThread().getName() + "消费商品:" + name + ",当前商品数量：" + queue.size());


    }
}

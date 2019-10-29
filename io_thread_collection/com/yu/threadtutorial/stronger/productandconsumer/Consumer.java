package com.yu.threadtutorial.stronger.productandconsumer;

public class Consumer implements Runnable {
    GoodsFactory factory;

    public Consumer(GoodsFactory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            factory.consume(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

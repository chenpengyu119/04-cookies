package com.yu.threadtutorial.stronger.productandconsume3;

public class Consumer implements Runnable {
    GoodsFactory factory;

    public Consumer(GoodsFactory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                factory.consume(Thread.currentThread().getName()+":"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

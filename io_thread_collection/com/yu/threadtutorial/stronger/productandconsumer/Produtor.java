package com.yu.threadtutorial.stronger.productandconsumer;

public class Produtor implements Runnable{
    GoodsFactory factory ;

    public Produtor(GoodsFactory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        int i=0;
        while (true) {
            factory.product(Thread.currentThread().getName()+":"+i);
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

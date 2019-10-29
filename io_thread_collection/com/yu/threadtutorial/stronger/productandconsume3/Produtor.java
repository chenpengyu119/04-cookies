package com.yu.threadtutorial.stronger.productandconsume3;

public class Produtor implements Runnable{
    GoodsFactory factory ;

    public Produtor(GoodsFactory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        int i=0;
        while (true) {
            try {
                factory.product(Thread.currentThread().getName()+":"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

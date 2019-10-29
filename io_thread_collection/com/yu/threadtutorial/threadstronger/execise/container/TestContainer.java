package com.yu.threadtutorial.threadstronger.execise.container;

import com.yu.threadtutorial.threadstronger.execise.printnum.Test;

import java.util.concurrent.ExecutorService;

/**
 * @author pengyu
 */
public class TestContainer {

    static Container container = new Container();

    public static void main(String[] args) {

        ExecutorService pool = Test.pool;

        for (int i = 0; i < 2; i++) {
            final int j = i;
            pool.execute(()->{
                Thread.currentThread().setName("add--"+j);
                container.add(j);
            });
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 2; i++) {
            final int j = i;
            pool.execute(()->{
                Thread.currentThread().setName("read--"+j);
                container.get(0);
            });
        }





    }
}
